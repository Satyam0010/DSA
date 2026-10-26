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
    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        helper1(root,sb);
        return sb.toString();
    }

    private void helper1(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("n,");
            return;
        }
        sb.append(root.val+",");
        helper1(root.left,sb);
        helper1(root.right,sb);
    }
    int index;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        String[] arr = data.split(",");
        return helper2(arr);
    }

    private TreeNode helper2(String[] arr){
        String value = arr[index++];
        if(value.equals("n")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = helper2(arr);
        root.right = helper2(arr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;