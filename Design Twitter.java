class Twitter {
    private static int timestamp = 0;
    private Map<Integer, List<int[]>> tweets = new HashMap<>();
    private Map<Integer, Set<Integer>> followMap = new HashMap<>();

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{timestamp++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Set<Integer> followees = followMap.getOrDefault(userId, new HashSet<>());
        followees.add(userId);

        for (int followee : followees) {
            List<int[]> tweetList = tweets.getOrDefault(followee, new ArrayList<>());
            maxHeap.addAll(tweetList);
        }

        List<Integer> res = new ArrayList<>();
        while (!maxHeap.isEmpty() && res.size() < 10) {
            res.add(maxHeap.poll()[1]);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
