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

        if(head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){                   // Cycle detected here, now find the starting point of loop
                
                ListNode start = head;
                while(start != slow){
                    start = start.next;
                    slow = slow.next;
                }
                return start;
                
            }
        }

        return null;                                    // Code comes here only when there is no cycle in loop, in which case return null
    }
}