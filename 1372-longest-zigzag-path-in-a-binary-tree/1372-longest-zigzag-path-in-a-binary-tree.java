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
    int ans;
    public int longestZigZag(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }
    private int[] dfs(TreeNode root){
        if(root == null) return new int[]{-1,-1};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int leftPath = 1 + left[1];
        int rightPath = 1 + right[0];
        ans = Math.max(ans,Math.max(leftPath,rightPath));
        return new int[]{leftPath,rightPath};
    }
}