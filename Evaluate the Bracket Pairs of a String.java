class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map=new HashMap<>();
        for(List<String>cur:knowledge){
            map.put(cur.get(0),cur.get(1));
        }
        StringBuilder ans=new StringBuilder();
        StringBuilder curStr=new StringBuilder();
        boolean open=false;
        for(char c:s.toCharArray()){
            if(c=='('){
                if(!curStr.isEmpty())ans.append(curStr);
                curStr.setLength(0);
                open=true;
            }else if(c==')'){
                if(open){
                    if(map.containsKey(curStr.toString())){
                        ans.append(map.get(curStr.toString()));
                    }else{
                        ans.append('?');
                    }
                }else{
                    ans.append(curStr);
                }
                curStr.setLength(0);
                open=false;
            }else{
                curStr.append(c);
            }
        }
        if(!curStr.isEmpty()){
            ans.append(curStr);
        }
        return ans.toString();
    }
}
