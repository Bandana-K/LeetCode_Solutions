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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null || (head.next == null && n == 1))
            return null;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode slow = dummy, fast = dummy;
        System.out.println( " fast val = " + fast.val);
        System.out.println( " slow val = " + slow.val);
        
        for(int i = 1; i <= n; i++){
            fast = fast.next;
            System.out.println(" i done = " + i + " fast val = " + fast.val);
        }

        while(fast.next != null){
            System.out.println( " fast val = " + fast.val);
            System.out.println( " slow val = " + slow.val);

            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}