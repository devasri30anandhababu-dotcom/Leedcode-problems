class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> st=new Stack<>();
        Stack<Integer> count=new Stack<>();
        int num=0;
        StringBuilder curr=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)) num=num*10+(ch-'0');
            else if(ch=='['){
                count.push(num);
                st.push(curr);
                num=0;
                curr=new StringBuilder();
            }
            else if(ch==']'){
                int temp=count.pop();
                StringBuilder prev=st.pop();
                while(temp>0){
                    prev.append(curr);
                    temp--;
                }
                curr=prev;
            }
            else curr.append(ch);
        }
        return curr.toString();
    }
}
