class Solution {
    public int findPairs(int[] nums, int k) {

        if(k<0) return 0;

        Arrays.sort(nums);

        int count = 0;

        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j=i+1; j<nums.length; j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int diff = Math.abs(nums[i] - nums[j]);
                if(diff == k){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
