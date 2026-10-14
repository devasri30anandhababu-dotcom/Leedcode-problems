public class Solution {
    private Map<Integer, List<Integer>> indices = new HashMap<>();

    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (!indices.containsKey(nums[i])) {
                indices.put(nums[i], new ArrayList<>());
            }
            indices.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        Random random = new Random();

        if (indices.containsKey(target)) {
            List<Integer> targetIndices = indices.get(target);
            int randomIndex = random.nextInt(targetIndices.size());
            return targetIndices.get(randomIndex);
        }

        return -1;
    }
}
