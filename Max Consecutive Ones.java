class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int tcnt = 0;

        for(int i=0; i < nums.length; i++){

            if(nums[i] == 1){
                tcnt +=1;

            }else{
                tcnt = 0;
            }
            
            if( tcnt > cnt){
                cnt = tcnt;
            } 
        }
        return cnt;
    }
}
