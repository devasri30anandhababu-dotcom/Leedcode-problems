class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num % k == 0) {
                set.add(num);
            }
        }
        int multiple = k;
        int j = 2;
        while (set.contains(multiple)) {
            multiple = j * k;
            j++;
        }
        return multiple;
    }
}
