class Solution { 
    private long f( long len) { 
        return (len-1)*(len-2)/2;
    }
    public int numberOfArithmeticSlices(int[] nums) {
        int cnt =0;
        int n = nums.length;
        for(int i=1;i<n;i++){ 
            int l = i-1;    // First term of AP (index)
            int r = i;      // second term of AP  (index)
            int d = nums[r]-nums[l];  // common difference 
            while(r<n && nums[r]-nums[r-1]==d) r++; 
            long len = r-l;     // length of AP 
            long sum = f(len);  // contributions of this AP

            cnt = cnt+ (int)(sum) ;

            i=r-1; // we already scanned this subarray so skip/ jump
        }
        return cnt;
    }
}
