class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        int count = 0;
        boolean[] composite = new boolean[n];

        for(int i = 2; i * i < n; i++){
            if(!composite[i]){
                for(int j = i * i; j < n; j += i){
                    composite[j] = true;
                }
            }
        }
        for(int i = 2; i < n; i++){
            if(!composite[i]) {
                count++;
            }
        }
        return count;
    }
}
