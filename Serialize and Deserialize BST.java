public class Codec {

    public String serialize(TreeNode root) {
        if(root==null)return "";
        StringBuilder sb=new StringBuilder();
        sb.append(root.val);

        Queue<TreeNode> q=new ArrayDeque<>();

        q.offer(root);

        while(!q.isEmpty()){
            TreeNode temp=q.poll();

            if(temp.left==null)sb.append(",null");
            else{
                sb.append(","+temp.left.val);
                q.offer(temp.left);
            }

            if(temp.right==null)sb.append(",null");
            else{
                sb.append(","+temp.right.val);
                q.offer(temp.right);
            }

        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.trim().equals(""))return null;
        String s[]=data.split(",");
        Queue<TreeNode> q=new ArrayDeque<>();
        TreeNode root=new TreeNode(Integer.parseInt(s[0]));
        q.add(root);
        
        int i=0;
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(2*i+1<s.length ){
                if(s[2*i+1].equals("null"))temp.left=null;
                else{
                    TreeNode left=new TreeNode(Integer.parseInt(s[2*i+1]));
                    q.offer(left);
                    temp.left=left;
                }
            }

            if(2*i+2<s.length ){
                if(s[2*i+2].equals("null"))temp.right=null;
                else{
                    TreeNode right=new TreeNode(Integer.parseInt(s[2*i+2]));
                    q.offer(right);
                    temp.right=right;
                }
            }

            i++;
            
        }

        return root;
    }
}

