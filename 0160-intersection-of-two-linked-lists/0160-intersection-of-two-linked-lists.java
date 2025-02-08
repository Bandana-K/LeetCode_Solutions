/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int n1 = countLength(headA);
        int n2 = countLength(headB);

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        if(n1 > n2){ //List1 is big, so move the temp1 pointer ahead by lengthDiff
            int lengthDiff = n1 - n2;
            for(int i = 1; i <= lengthDiff; i++){
                temp1 = temp1.next;
            }
        } else if(n1 < n2){ //List2 is big, so move the temp2 pointer ahead by lengthDiff
            int lengthDiff = n2 - n1;
            for(int i = 1; i <= lengthDiff; i++){
                temp2 = temp2.next;
            }
        }
        
        while(temp1 != null && temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if(temp1 == null) return null;
        return temp1;
            
    }

    private int countLength(ListNode head){
        if (head == null)
            return 0;

        return 1+ countLength(head.next);    
    }
}