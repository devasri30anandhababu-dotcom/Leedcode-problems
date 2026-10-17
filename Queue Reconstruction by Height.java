class Solution {
    public int[][] reconstructQueue(int[][] people) {
        ArrayList<int[]> list = new ArrayList<>();

        Arrays.sort(people, (a,b) -> {
            if(a[0] - b[0] == 0) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        int n = people.length;

        for(int[] person : people) {
            list.add(person[1], person);
        }

        int[][] ans = new int[people.length][2];
        for(int i=0; i<n; i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        return ans;
    }
}
