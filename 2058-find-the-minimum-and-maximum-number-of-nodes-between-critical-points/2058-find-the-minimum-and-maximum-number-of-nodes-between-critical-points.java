/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {-1,-1};
        if(head == null || head.next == null || head.next.next == null) return ans;
        ListNode prev = head;
        ListNode pre = head.next;
        ListNode post = pre.next;
        List<Integer> list = new ArrayList<>();
        int index = 1;
        while(post != null){
            if((pre.val > prev.val && pre.val > post.val) || (pre.val < prev.val && pre.val < post.val)){
                list.add(index);
            }
            index++;
            prev = pre;
            pre = post;
            post = post.next;
        }
        if(list.size() < 2) return ans;
        ans[0] = Integer.MAX_VALUE;
        ans[1] = list.get(list.size()-1) - list.get(0);
        for(int i = 1;i < list.size();i++){
            if(list.get(i) - list.get(i-1) < ans[0]) ans[0] = list.get(i) - list.get(i-1);
        }
        return ans;
    }
}