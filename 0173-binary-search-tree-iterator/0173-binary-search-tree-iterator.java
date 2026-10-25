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
class BSTIterator {
    List<Integer> list;
    int pointer ;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        add(root);
        pointer = -1;
    }
    
    public int next() {
        return list.get(++pointer);
    }
    
    public boolean hasNext() {
        return pointer+1 < list.size();
    }

    private void add(TreeNode root){
        if(root == null) return;
        add(root.left);
        list.add(root.val);
        add(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */