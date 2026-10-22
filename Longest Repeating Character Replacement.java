class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int maxLen = 0, maxFreq = 0, left = 0, right = 0;

        while(right < n){
            char ch = s.charAt(right);
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            if((right - left + 1) - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen , (right - left + 1));
            right++;
        }

        return maxLen;
    }
}
