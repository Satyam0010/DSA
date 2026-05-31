/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    StringBuilder s = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        helper1(root,s);
        return s.toString();
    }
    private void helper1(TreeNode root, StringBuilder s){
        if(root == null){
            s.append("n,");
            return;
        }
        s.append(root.val).append(',');
        helper1(root.left,s);
        helper1(root.right,s);
    }
    int index = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ar = data.split(",");
        return helper2(ar);
    }
    private TreeNode helper2(String[] data){
        if(data[index].equals("n")){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data[index++]));
        root.left = helper2(data);
        root.right = helper2(data);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));