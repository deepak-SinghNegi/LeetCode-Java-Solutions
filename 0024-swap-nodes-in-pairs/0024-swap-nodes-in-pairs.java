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
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        ListNode ptr = dummy;
        while (curr != null && curr.next != null) {
            ptr.next = new ListNode(curr.next.val);
            ptr = ptr.next;
            ptr.next = new ListNode(curr.val);
            ptr = ptr.next;
            curr = curr.next.next;
        }
        if(curr !=null){
            ptr.next = curr;
        }
        return dummy.next;
    }
}