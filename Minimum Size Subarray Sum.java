class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                // Update minimum length and shrink the window
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
