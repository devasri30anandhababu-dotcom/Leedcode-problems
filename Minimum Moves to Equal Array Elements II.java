class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length, cnt = 0;
        Arrays.sort(nums);
        int x = nums[n / 2];
        for (int i = 0; i < n; i++) {
            cnt += Math.abs(nums[i] - x);
        }
        return cnt;
    }
}
