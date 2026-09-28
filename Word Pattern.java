class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> hm = new HashMap<>();
        String arr[] = s.trim().split("\\s+");
        if (pattern.length() != arr.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (hm.containsKey(ch)) {
                if (!hm.get(ch).equals(arr[i])) {
                    return false;
                }
            }
            else {
                if (hm.containsValue(arr[i])) 
                    return false;

                hm.put(ch, arr[i]);
            }
        }
        return true;
    }
}
