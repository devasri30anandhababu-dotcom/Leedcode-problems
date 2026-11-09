/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer,Integer>freq=new HashMap<>();
    int maxValue=0,maxCount=0,max=0;
    public int[] findMode(TreeNode root) {
        if(root.left==null&&root.right==null)return new int[]{root.val};
        helper(root);
        if(maxCount==1)return new int[]{max};
        int[]ans=new int[maxCount];
        int index=0;
        for(int val:freq.keySet()){
            if(freq.get(val)==maxValue)ans[index++]=val;
        }
        return ans;        
    }
    public void helper(TreeNode node){
        if(node==null)return;
        helper(node.left);
        freq.put(node.val,freq.getOrDefault(node.val,0)+1);
        if(freq.get(node.val)==maxValue){
            maxCount++;
        }
        else if(freq.get(node.val)>maxValue){
            max=node.val;
            maxValue=freq.get(node.val);
            maxCount=1;
        }
        helper(node.right);
    }
}
