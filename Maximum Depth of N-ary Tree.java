class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;

        int maxHeight = 0;
        for(Node child : root.children){
            maxHeight = Math.max(maxHeight, maxDepth(child));
        }

        return 1 + maxHeight;
    }
}
