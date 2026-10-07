class Solution {

    public int countNumbersWithUniqueDigits(int n) {
        int res[] = new int[n+1];
        res[0] = 1;

        for(int i=1;i<=n;i++){
            int j = i-1, m = 9, val = 9;
            while(j>0){
                val*=m;
                m--;
                j--;
            }
            res[i] = val+res[i-1];
        }
        return res[n];
    }
}
