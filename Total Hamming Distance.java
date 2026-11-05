class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int bit = 0;
            for (int j : nums)
                bit += (j >> i) & 1;
            ans += bit * (nums.length - bit);
        }
        return ans;
    }
}
