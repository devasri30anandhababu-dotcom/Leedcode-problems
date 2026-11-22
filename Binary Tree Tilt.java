class Solution {
    private int total = 0;

    public int findTilt(TreeNode root) {
        sum(root);

        return total;
    }

    private int sum(TreeNode root){
        if(root == null) return 0;

        int left = sum(root.left);
        int right = sum(root.right);

        total += Math.abs(left - right);

        return root.val + left + right;
    }
}
