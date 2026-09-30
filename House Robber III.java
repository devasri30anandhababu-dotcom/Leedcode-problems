class Solution {
    public int rob(TreeNode root) {
        int[] option=helper(root);
        return Math.max(option[0],option[1]);
    }
    public int[] helper(TreeNode root){
        if(root==null) return new int[2];

        int[] left=helper(root.left);
        int[] right=helper(root.right);
        int[] option=new int[2];

        option[0]=root.val+ left[1]+right[1];
        option[1]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);

        return option;
    }
}
