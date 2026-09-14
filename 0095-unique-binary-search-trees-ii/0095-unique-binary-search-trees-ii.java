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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return find(1,n);
    }

    private List<TreeNode> find(int l,int r){
        List<TreeNode> ans = new ArrayList<>();
        if( l >= r){
            if(l == r){
                TreeNode node = new TreeNode(l);
                ans.add(node);
            } else {
                ans.add(null);
            }
            return ans;
        }

        for(int i = l ; i <= r;i++ ){
            List<TreeNode> left = find(l,i-1);
            List<TreeNode> right = find(i+1,r);
            for(TreeNode ll : left){
                for(TreeNode rr : right){
                    TreeNode root = new TreeNode(i);
                    root.left = ll;
                    root.right = rr;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}