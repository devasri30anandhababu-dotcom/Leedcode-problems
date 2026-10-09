class Solution {
    public int lengthLongestPath(String input) {
        int maxlength = 0;
        Stack<Integer> pathlengths = new Stack<>();
        String[] lines = input.split("\n");
        
        for (String line : lines) {
            int depth = 0;

            while (line.charAt(depth) == '\t') {
                depth++;
            }

            while (pathlengths.size() > depth) {
                pathlengths.pop();
            }

            String name = line.substring(depth);
            int length = (pathlengths.isEmpty() ? 0 : pathlengths.peek()) + name.length() + (pathlengths.isEmpty() ? 0 : 1);

            if (name.contains(".")) {
                maxlength = Math.max(maxlength, length);
            } else {
                pathlengths.push(length);
            }
        }
        return maxlength;
    }
}
