class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] st = new int[n];
        int ptr = -1;
        int KVal = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int iVal = nums[i];
            if (iVal < KVal)
                return true;
            while (ptr >= 0 && st[ptr] < iVal)
                KVal = st[ptr--];
            st[++ptr] = iVal;
        }
        return false;
    }
}
