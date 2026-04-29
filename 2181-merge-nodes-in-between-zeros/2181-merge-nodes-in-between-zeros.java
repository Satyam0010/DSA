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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = head;
        ListNode pre = dummy;
        int sum = 0;
        head = head.next;
        while(head != null){
            if(head.val == 0){
                pre.next = new ListNode(sum);
                pre = pre.next;
                sum = 0;
            } else {
                sum += head.val;
            }
            head = head.next;
        } return dummy.next;
    }
}