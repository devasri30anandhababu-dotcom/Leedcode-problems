class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        if (root == null)
            return res;

        StringBuilder path = new StringBuilder();
        path.append(root.val);
        backtrack(root, path, res);

        return res;
    }

    private void backtrack(TreeNode root, StringBuilder path, List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(path.toString());
            return;
        }

        int size = path.length();

        if (root.left != null) {
            path.append("->").append(root.left.val);
            backtrack(root.left, path, res);
            path.setLength(size);
        }

        if (root.right != null) {
            path.append("->").append(root.right.val);
            backtrack(root.right, path, res);
            path.setLength(size);
        }
    }
}
