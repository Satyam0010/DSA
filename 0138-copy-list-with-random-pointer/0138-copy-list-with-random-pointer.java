/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;
        while(curr != null){
            Node next = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = next;
            curr = next;
        }
        for(curr = head ; curr != null ; curr = curr.next.next){
            curr.next.random = (curr.random == null) ? null : curr.random.next;
        }
        curr = head;
        Node head2 = curr.next;
        Node clone = head2;
        while(curr != null){
            curr.next = curr.next.next;
            clone.next = clone.next != null ? clone.next.next : null;
            clone = clone.next;
            curr = curr.next;
        }
        return head2;
    }
}