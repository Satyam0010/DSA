/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
             int c = 1;
             ListNode temp = slow.next;
             while(temp != slow){
                c++;
                temp = temp.next;
             }

             ListNode p1 = head;
             ListNode p2 = head;

             for(int i = 0 ; i < c; i++){
                p2 = p2.next;
             }

             while(p1 != p2){
                p1 = p1.next;
                p2 = p2.next;
             }

             return p1;
            }
        }
            return null;
    }
}