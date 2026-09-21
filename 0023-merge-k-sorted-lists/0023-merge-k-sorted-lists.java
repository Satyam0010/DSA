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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) return null;
        return breakAndMerge(0,n-1,lists);
    }

    private ListNode breakAndMerge(int start, int end, ListNode[] lists){
        if(start > end) return null;
        if(start == end) return lists[start];
        int mid = start + ( end- start )/2;
        ListNode l1 = breakAndMerge(start,mid,lists);
        ListNode l2 = breakAndMerge(mid+1,end,lists);
        return mergeTwoLists(l1,l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}