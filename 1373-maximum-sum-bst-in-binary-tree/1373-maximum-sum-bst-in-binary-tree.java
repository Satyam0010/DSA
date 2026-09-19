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
    int ans = 0;
    public int maxSumBST(TreeNode root) {
        check(root);
        return ans;
    }
    //int[] ka order -> minValue, maxValue, sum
    private int[] check(TreeNode root){
        if(root == null) return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        int[] leftTree = check(root.left);
        int[] rightTree = check(root.right);
        if(root.val > leftTree[1] && root.val < rightTree[0]){
            int currSum = root.val + leftTree[2] + rightTree[2];
            ans = Math.max(ans,currSum);
            int currMin = Math.min(root.val, leftTree[0]);
            int currMax = Math.max(root.val, rightTree[1]);
            return new int[]{currMin,currMax,currSum};
        }
        return new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE,0};
    }
}