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
    int length,i;
    public TreeNode recoverFromPreorder(String traversal) {
        length = traversal.length();
        return find(traversal,0);
    }

    private TreeNode find(String s, int depth){
        if(i >= length) return null;
        int j = i;
        while( j < length && s.charAt(j) == '-') j++;
        int dashes = j-i;
        if(dashes != depth) return null;
        i += dashes;
        int num = 0;
        while(i < length && (s.charAt(i) >= 48 && s.charAt(i) <= 57)){
            num = (num*10) + (s.charAt(i)-'0');
            i++;
        }

        TreeNode root = new TreeNode(num);
        root.left = find(s,depth+1);
        root.right = find(s,depth+1);
        return root;
    }
}