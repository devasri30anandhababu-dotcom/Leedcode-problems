class Solution {
    public int minDistance(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i < m || j < n)
                    dp[i][j] = i < m && j < n && a.charAt(i) == b.charAt(j) ?
                        dp[i + 1][j + 1] : 1 + Math.min((i < m ? dp[i + 1][j] : Integer.MAX_VALUE), (j < n ? dp[i][j + 1] : Integer.MAX_VALUE));
            }
        }
        return dp[0][0];
    }
}
