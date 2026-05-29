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
    ArrayList<TreeNode> arr = new ArrayList<>();
    public void flatten(TreeNode root) {
        if(root == null) return;
        preorder(root);
        for(int i = 0; i < arr.size()-1;i++){
            TreeNode a = arr.get(i);
            TreeNode b = arr.get(i+1);
            a.left = null;
            a.right = b;
        }
        TreeNode last = arr.get(arr.size()-1);
        last.left = null;
        last.right = null;
    }

    private void preorder(TreeNode root){
        if(root == null) return;
        arr.add(root);
        preorder(root.left);
        preorder(root.right);
    }
}