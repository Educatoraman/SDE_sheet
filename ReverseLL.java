/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 LOGIC --> Mai 2 pointers ka use karunga for Reversing a LL
 h --> head pointers
 h
 1 --> 2 --> 3 --> 4 --> 5 --> NULL

 initially prev = null and curr = head
 REVERSE ka logic --> basically mai current and prev pointer lunga, ek while loop chalaunga jab tak curr!=NULL
 and uske andar aapko ye cheez krni hai
 temp = curr.next 
 curr.next = prev
 prev = curr
 curr = temp
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
