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
    int levelofx = 0;
    int levelofy = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        levelofx = level(root,x,0);
        levelofy = level(root,y,0);
        if(levelofx == levelofy){
            TreeNode parentofx = check(root,x);
            TreeNode parentofy = check(root,y);
            if(parentofx != parentofy) return true;
        }
        return false;
    }
    private int level(TreeNode root, int x,int level){
        if(root == null) return -1;
        if(root.val == x) return level;
        int left = level(root.left,x,level+1);
        if(left != -1) return left;
        return level(root.right,x,level+1);
    }
    private TreeNode check(TreeNode root,int x){
        if(root == null) return null;
        if(root.left != null && root.left.val == x) return root;
        if(root.right != null && root.right.val == x) return root;
        TreeNode left = check(root.left,x);
        if(left != null) return left;
        return check(root.right,x);
    }
}