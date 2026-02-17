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
    public ListNode reverseList(ListNode head) {
        
        if(head==null || head.next==null) return head;
        ListNode l =null;
        ListNode curr = head;
        
       
        while(curr!=null){
           ListNode r = curr.next;
           curr.next = l;
           l =curr;
           curr = r;

        }

        return l;
    }

}