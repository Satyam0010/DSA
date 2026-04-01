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
    public void reorderList(ListNode head) {


        if(head == null || head.next == null){
            return;
        }


        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode pre = slow.next;
        slow.next = null;
        

        while(pre != null){

            ListNode post = pre.next;
            pre.next = prev;
            prev = pre;
            pre = post;
        }

        ListNode start = head;
        ListNode start2 = prev;
        while(start2 != null){
            ListNode temp = start.next;
            start.next = start2;
            start = temp;
        
            temp = start2.next;
            start2.next = start;
            start2 = temp;
    }
}
}