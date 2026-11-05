class Solution {
    public int magicalString(int n) {
        if(n == 1) return 1;

        StringBuilder st = new StringBuilder();
        st.append(1).append(2).append(2);
        int ind = 2;
        int one = 1;
        while(st.length() <= n){
            int sz = st.charAt(ind)-'0';
            int val = st.charAt(st.length()-1) == '1' ? 2 : 1;
            for(int i = 0;i < sz;i++) st.append(val);
            
            if(sz == 1) one++;
            ind++;
        }
        
        while(ind < n){
            if(st.charAt(ind)=='1') one++;
            ind++;
        }
        
        return one;
    }
}
