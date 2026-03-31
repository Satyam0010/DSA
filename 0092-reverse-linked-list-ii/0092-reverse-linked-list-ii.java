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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }

        ListNode prev = null;
        ListNode pre = head;
        for(int i = 0; pre != null && i < left-1; i++){
            prev = pre;
            pre = pre.next;
        }

        ListNode last = prev;
        ListNode newend = pre;
        ListNode next = pre.next;
        for(int i = 0; pre != null && i < right - left+1; i++){
            pre.next = prev;
            prev = pre;
            pre = next;
            if(next != null){
                next = next.next;
            } 
        }

        if( last != null){
            last.next = prev;
        } else {
            head = prev;
        }

        newend.next = pre;

        return head;
    }
}