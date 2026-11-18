class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] seen = new boolean[1440];
        for (String t : timePoints) {
            int h = Integer.parseInt(t.substring(0, 2));
            int m = Integer.parseInt(t.substring(3));
            int time = h * 60 + m;
            if (seen[time]) return 0;
            seen[time] = true;
        }
        int first = -1, prev = -1, ans = Integer.MAX_VALUE;
        for (int i = 0; i < 1440; i++) {
            if (seen[i]) {
                if (first == -1) first = i;
                if (prev != -1) ans = Math.min(ans, i - prev);
                prev = i;
            }
        }
        ans = Math.min(ans, 1440 - prev + first);
        return ans;
    }
}
