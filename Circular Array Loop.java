class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;

        boolean[] visited = new boolean[len];
        for(int i = 0; i < len; i++){
            if(!visited[i]){
                if(nums[i] > 0){
                    pos = true;
                    if(passing(visited, i, nums, len, true, new boolean[len]) && pos) return true;
                }
                else{
                    pos = false;
                    if(passing(visited, i, nums, len, true, new boolean[len]) && !pos) return true;
                }

            }
        }

        return false;
    }

    boolean pos;
    public boolean passing(boolean[] visited, int ind, int[] nums, int len, boolean flg, boolean[] visit){
        if(visit[ind]) return true;
        visited[ind] = true;

        visit[ind] = true;
        int limit = ind+nums[ind];
        limit %= len;
        
        if(flg && pos && nums[ind] < 0){
            pos = false;
            flg = false;
        }
        else if(flg && !pos && nums[ind] > 0){
            pos = true;
            flg = false;
        }

        if(limit >= len) limit %= len;
        if(limit < 0) limit = len+limit;

        if(limit == ind || !flg) return false;
        return passing(visited, limit, nums, len, flg, visit);
    }
}
