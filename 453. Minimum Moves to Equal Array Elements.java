class Solution {
    public int minMoves(int[] nums) {
        int smallestNum = Integer.MAX_VALUE;

        for(int num : nums){
            smallestNum = Math.min(num, smallestNum);
        }
        int minMoves = 0;

        for(int num : nums){
            minMoves += num - smallestNum;
        }
        
        return minMoves;
    }
}
