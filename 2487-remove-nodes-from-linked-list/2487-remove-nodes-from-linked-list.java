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
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        ListNode pre = head;
        while(pre != null && pre.next != null){
            if(pre.next.val < pre.val){
                pre.next = pre.next.next;
            }else{
                pre = pre.next;
            }
        }
        return reverse(head);
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode pre = head;
        while(pre != null){
            ListNode next = pre.next;
            pre.next = prev;
            prev = pre;
            pre = next;
        }
        return prev;
    }
}