class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        int[] res = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                res[index++] = entry.getKey();
                if (index == 2) {
                    break;
                }
            }
        }

        return res;
    }
}
