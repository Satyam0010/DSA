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
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        if(root.left == null && root.right == null){
            ans.add(String.valueOf(root.val));
            return ans;
        }
        find(root,new StringBuilder());
        return ans;
    }

    private void find(TreeNode root,StringBuilder st){
        if(root == null) return;
        int length = st.length();
        st.append(root.val);
        if(root.left == null && root.right == null){
            ans.add(st.toString());
        } else {
            st.append("->");
        find(root.left,st);
        find(root.right,st);
        }
        st.setLength(length);
    }
}