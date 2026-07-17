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
    public int rob(TreeNode root) {
        int[] arr = check(root);
        return Math.max(arr[0],arr[1]);
    }

        private int[] check(TreeNode root){
            if(root == null) return new int[2];
            int[] left = check(root.left);
            int[] right = check(root.right);
            int[] op = new int[2];
            op[0] = root.val + left[1] + right[1];
            op[1] = Math.max(left[0] ,left[1]) + Math.max(right[0],right[1]);

            return op;
        }
}