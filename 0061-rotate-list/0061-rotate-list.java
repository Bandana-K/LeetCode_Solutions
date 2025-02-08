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
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null) return head;

        int length = countNodes(head);
        int rotation = k%length;
        
        if(rotation == 0) return head;
        
        ListNode newEnd = findKthNodeFromLast(head, rotation);
        ListNode newHead = newEnd.next;
        newEnd.next = null;

        ListNode temp = newHead;
        while(temp!= null && temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        return newHead;
    }

    ListNode findKthNodeFromLast(ListNode head, int k){
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        for(int i = 1; i <= k ; i++){
            fast = fast.next;
        }

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    int countNodes(ListNode head){
        if(head == null) return 0;
        return 1+ countNodes(head.next);
    }
}