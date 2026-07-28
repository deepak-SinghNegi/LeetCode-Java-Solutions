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
    public ListNode swapNodes(ListNode head, int k) {
        int size = 0;
        ListNode curr = head;
        ListNode strPtr = head;
        while (curr != null) {
            if (++size == k) {
                strPtr = curr;
                break;
            }
            curr = curr.next;
        }
        ListNode endPtr = head;
        while (curr != null && curr.next != null) {
            curr = curr.next;
            endPtr = endPtr.next;
        }
        int endVal = endPtr.val;
        endPtr.val = strPtr.val;
        strPtr.val = endVal;
        return head;
    }
}