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
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        check(root,targetSum,ans,list);
        return ans;
    }
    private void check(TreeNode root,int sum,List<List<Integer>> ans,List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        if(root.left == null && root.right == null){
            if(root.val == sum){
                ans.add(new ArrayList<>(list));
            }
        }
        check(root.left,sum-root.val,ans,list);
        check(root.right,sum-root.val,ans,list);
        if(!list.isEmpty()){
            list.remove(list.size()-1);
        }
    }
}