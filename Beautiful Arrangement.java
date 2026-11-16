class Solution {
    private int count=0;
    public int countArrangement(int n) {
        boolean []visited=new boolean[n+1];
        solve(0,n,visited);
        return count;
    }
    public void solve(int i,int n,boolean[]visited){
        if(i==n){
            count++;
            return ;
        }
        int pos=i+1;
        for(int a=1;a<=n;a++){
             if(!visited[a]&&(((pos%a)==0)||((a%pos)==0))){
                visited[a]=true;
                solve(i+1,n,visited);
                visited[a]=false;
             }
        }
    }
}
