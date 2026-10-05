class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> seen = new HashSet<>();
        for(int num : nums1)
        {
            seen.add(num);
        }
        HashSet<Integer> result = new HashSet<>();
        for(int num : nums2)
        {
            if(seen.contains(num))
            {
                result.add(num);
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        for(int num : result)
        {
            res[i] = num;
            i ++;
        }
        return res;
    }
}
