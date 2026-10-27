class Solution {
    public int minMoves(int[] nums) {
        int mn = Integer.MAX_VALUE;

        for (int num : nums) {
            mn = Math.min(mn, num);
        }

        int moves = 0;

        for (int num : nums) {
            moves += num - mn;
        }

        return moves;
    }
}
