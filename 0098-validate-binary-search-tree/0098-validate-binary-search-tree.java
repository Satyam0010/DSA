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
    Integer prev = null;
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        validate(root);
        return flag;
    }
    private void validate(TreeNode root){
        if(root == null) return;
        validate(root.left);
        if(prev != null && root.val <= prev) {
            flag = false;
            return;
        }
        prev = root.val;
        validate(root.right);
    }

}