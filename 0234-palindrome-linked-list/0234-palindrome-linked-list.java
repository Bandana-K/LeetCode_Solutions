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

        if(head == null || head.next == null) return true;              //If head is null or only 1 element present then its palindrome

        ListNode temp = head;
        ListNode midNode = findMidNode(temp);                           //find the mid elelemt in order to reverse next half of the list.
        ListNode reversedListhead = reverseLinkedList(midNode.next);    //reverse the next half of the list and get the head of reversedList
        ListNode newTemp = reversedListhead;

        while(newTemp != null){
            if(newTemp.val != temp.val){
                reverseLinkedList(midNode.next);                        //Reverse the reversed 2nd half ensuring original list remains same
                return false;
            }
            newTemp = newTemp.next;
            temp = temp.next;
        }

        reverseLinkedList(midNode.next);                                //Reverse the reversed 2nd half ensuring original list remains same
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