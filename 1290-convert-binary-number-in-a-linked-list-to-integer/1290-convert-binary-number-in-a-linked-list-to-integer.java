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
    public int getDecimalValue(ListNode head) {
        if(head.next ==null) return (int)(head.val * Math.pow(2, 0));
        int i = 0;
        int val = 0;
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        while (prev != null) {
            val += prev.val * Math.pow(2, i++);
            prev = prev.next;
        }
        return val;
    }
}