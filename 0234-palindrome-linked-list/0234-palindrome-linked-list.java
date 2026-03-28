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
    public boolean isPalindrome(ListNode head) {
        ListNode h = head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }

        ListNode nh = helper(slow);

        while(nh != null){
            if(nh.val != h.val){
                return false;
            }

            nh = nh.next;
            h = h.next;
        }

        return true;
    }

    ListNode helper(ListNode n){
        if(n == null || n.next == null){
            return n;
        }
        ListNode t = helper(n.next);
        n.next.next = n;
        n.next = null;
        return t;
    }
}