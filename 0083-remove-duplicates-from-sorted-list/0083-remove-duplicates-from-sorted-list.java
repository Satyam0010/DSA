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
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null){
            return null;
        }
        
        ListNode n = new ListNode(-1);
        ListNode ans = n;
    
        while(head != null){
            if(ans == n || ans.val != head.val){
                ans.next = new ListNode(head.val);
                ans = ans.next;
            }
            head = head.next;
        }
        return n.next;
    }
}