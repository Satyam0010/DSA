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
    Map<Integer,List<Integer>> map;
    public int amountOfTime(TreeNode root, int start) {
        map = new HashMap<>();
        buildMap(root,null);
        int ans = -1;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.offer(start);
        set.add(start);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int front = q.poll();
                if(map.containsKey(front)){
                    for(int neighbour : map.get(front)){
                        if(!set.contains(neighbour)){
                            set.add(neighbour);
                            q.offer(neighbour);
                        }
                    }
                }
            }
            ans++;
        }
        return ans;
    }

    private void buildMap(TreeNode root, TreeNode parent){
        if(root == null) return;
        map.putIfAbsent(root.val,new ArrayList<>());
        if(parent != null){
            map.get(root.val).add(parent.val);
            map.get(parent.val).add(root.val);
        }

        buildMap(root.left,root);
        buildMap(root.right,root);
    }
}