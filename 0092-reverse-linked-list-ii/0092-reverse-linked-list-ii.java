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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // if (head == null || head.next == null || left == right)
        //     return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode lPre = dummy;
        for (int i = 1; i < left; i++) {
            lPre = lPre.next;
        }
        ListNode l = lPre.next;
        ListNode prev = null;
        ListNode curr = l;
        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        l.next = curr;
        lPre.next = prev;
        dummy = dummy.next;
        return dummy;

    }
}