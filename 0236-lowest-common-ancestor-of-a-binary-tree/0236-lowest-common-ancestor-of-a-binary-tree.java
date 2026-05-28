/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return root;
        boolean isleftp = exist(root.left,p);
        boolean isleftq = exist(root.left,q);
        if(isleftp && isleftq) return lowestCommonAncestor(root.left,p,q);
        else if(!isleftp && !isleftq) return lowestCommonAncestor(root.right,p,q);
        return root;
    }
    private boolean exist(TreeNode root,TreeNode a){
        if(root == null) return false;
        if(root.val == a.val) return true;
        return exist(root.left,a) || exist(root.right,a);
    }
}