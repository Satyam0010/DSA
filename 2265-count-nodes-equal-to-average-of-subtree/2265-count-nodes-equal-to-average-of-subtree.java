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
    public int averageOfSubtree(TreeNode root) {
        check(root);
        return ans;
    }

    private int[] check(TreeNode root){
        if(root == null) return new int[]{0,0};
        int[] left = check(root.left);
        int[] right = check(root.right);
        int currSum = left[0] + right[0] + root.val;
        int currCount = left[1]+right[1]+1;
        if(root.val == (currSum/currCount)) ans++;
        return new int[]{currSum,currCount};
    }
}