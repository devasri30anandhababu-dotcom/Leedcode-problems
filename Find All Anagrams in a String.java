class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n1 = s.length();  
        int n2 = p.length();  

        List<Integer> ans = new ArrayList<>();

        if (n1 < n2) return ans;

        int[] a = new int[26]; 
        int[] b = new int[26]; 

        for (int i = 0; i < n2; i++) {
            a[p.charAt(i) - 'a']++;
            b[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(a, b)) {
            ans.add(0);
        }

        for (int i = n2; i < n1; i++) {
            b[s.charAt(i) - 'a']++;           
            b[s.charAt(i - n2) - 'a']--;     

            if (Arrays.equals(a, b)) {
                ans.add(i - n2 + 1);
            }
        }

        return ans;
    }
}
