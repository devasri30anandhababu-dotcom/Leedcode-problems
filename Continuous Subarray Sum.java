class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remaindersFound = new HashMap<>();
        int currSum = 0;
        remaindersFound.put(0, -1); 

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            int remainder = currSum % k;

            if (remaindersFound.containsKey(remainder)) {
                if (i - remaindersFound.get(remainder) >= 2) {
                    return true;
                }
            } else {
                remaindersFound.put(remainder, i);
            }
        }

        return false;
    }
}
