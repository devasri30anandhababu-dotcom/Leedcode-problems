class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        
        int n=wall.size();
        Map<Integer,Integer>map=new HashMap<>();
         int maxi=0;
         int summ=0;
         
         for(int i=0;i<wall.get(0).size();++i)
         {
           summ+=wall.get(0).get(i);
         }
        for(int i=0;i<n;++i)
        {
            int m=wall.get(i).size();
            int sum=wall.get(i).get(0);
            map.put(sum,map.getOrDefault(sum,0)+1);
            if(sum!=summ)
                maxi=Math.max(maxi,map.get(sum));
            for(int j=1;j<m;++j)
            {
                sum+=wall.get(i).get(j);
                map.put(sum,map.getOrDefault(sum,0)+1);

                if(sum!=summ)
                maxi=Math.max(maxi,map.get(sum));
            }
            
        }

        return n-maxi;
    }
}
