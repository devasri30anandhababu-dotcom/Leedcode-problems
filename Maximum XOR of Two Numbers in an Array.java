class Node{
    Node link[]=new Node[2];

    boolean containsKey(int ind){
        return (link[ind]!=null);
    }

    void put(int ind,Node node){
        link[ind]=node;
    }

    Node get(int ind){
        return link[ind];
    }
}

class Trie{
    Node root;
    Trie(){
        root=new Node();
    }
    void insert(int num){
        Node node=root;
        for(int i=31;i>=0;i--){
            int set=((num>>i)&1);
            if(!node.containsKey(set)){
                node.put(set,new Node());
            }
            node=node.get(set);
        }
    }

        int getMax(int num){
            Node node=root;
            int maxNum=0;
            for(int i=31;i>=0;i--){
                int set=((num>>i)&1);
                if(node.containsKey(1-set)){
                    maxNum=(maxNum|1<<i);
                    node=node.get(1-set);
                }
                else node=node.get(set);
            }
            return maxNum;
        }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie=new Trie();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            trie.insert(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            max=Math.max(trie.getMax(nums[i]),max);
        }
        return max;
    }
}
