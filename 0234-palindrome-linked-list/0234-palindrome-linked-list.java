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

        if(head == null || head.next == null) return true;

        ListNode temp = head;
        ListNode midNode = findMidNode(temp);
        System.out.println("midNode = " + midNode.val);

        ListNode reversedListhead = reverseLinkedList(midNode.next);
        System.out.println("reversedListhead = " + reversedListhead.val);

        ListNode newTemp = reversedListhead;

        while(newTemp != null){
            System.out.println("newTemp = " + newTemp.val + " temp = " + temp.val);
            if(newTemp.val != temp.val){
                reverseLinkedList(midNode.next);
                return false;
            }
            newTemp = newTemp.next;
            temp = temp.next;
        }

        reverseLinkedList(midNode.next);
        return true;    
    }

    private ListNode findMidNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseLinkedList(ListNode head){
        
        if(head == null || head.next == null) return head;
        
        ListNode temp = head;
        ListNode newHead = reverseLinkedList(temp.next);
        temp.next.next = temp;
        temp.next = null;
        return newHead;
    }
    
}