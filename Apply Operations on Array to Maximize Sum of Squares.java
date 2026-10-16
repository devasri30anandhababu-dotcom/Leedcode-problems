class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final long MOD = 1_000_000_007;
        int[] cnt = new int[30];  
        for (int x : nums)
            for (int b = 0; b < 30; b++) cnt[b] += x >> b & 1;
        long total = 0;
        for (int i = 0; i < k; i++) {  
            long row = 0;
            for (int b = 0; b < 30; b++)
                if (cnt[b] > i) row |= 1L << b; 
            total = (total + row * row) % MOD;
        }
        return (int) total;
    }
}
