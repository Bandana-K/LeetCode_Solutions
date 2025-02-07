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
class Solution { // recurrsive approach
    public ListNode reverseList(ListNode head) {
        
        if(head == null || head.next == null)
            return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }
}


class Other_Solution { // iterative approach
    public ListNode reverseList(ListNode head) {
        
        if(head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode temp = head;

        while(temp != null && temp.next != null){
            ListNode front = temp.next;
            front.next = temp;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}