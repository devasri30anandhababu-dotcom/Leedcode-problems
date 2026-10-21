class Solution { 
    private long f( long len) { 
        return (len-1)*(len-2)/2;
    }
    public int numberOfArithmeticSlices(int[] nums) {
        int cnt =0;
        int n = nums.length;
        for(int i=1;i<n;i++){ 
            int l = i-1;    
            int r = i;      
            int d = nums[r]-nums[l]; 
            while(r<n && nums[r]-nums[r-1]==d) r++; 
            long len = r-l;     
            long sum = f(len);  

            cnt = cnt+ (int)(sum) ;

            i=r-1; 
        }
        return cnt;
    }
}
