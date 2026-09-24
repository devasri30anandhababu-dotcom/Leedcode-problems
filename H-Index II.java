class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int start = 0;
        int end = n;
        int ans = 0;

        while(start <= end) {
            int h = start + (end - start) / 2;
            int count = 0;

            for(int i=n-1; i>=0; i--) {
                if(citations[i] >= h) {
                    count++;
                } else {
                    break;
                }
            }

            if(count >= h) {
                ans = h;
                start = h + 1;
            } else {
                end = h - 1;
            }
        }

        return ans;
    }
} 
