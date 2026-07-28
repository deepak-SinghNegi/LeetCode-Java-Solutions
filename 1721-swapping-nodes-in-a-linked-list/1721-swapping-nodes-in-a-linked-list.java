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
        ListNode temp = head;
        ListNode ptr = null;
        while (temp != null) {
            if (++size == k) {
                ptr = temp;
            }
            temp = temp.next;
        }
        k = size - k + 1;
        temp = head;
        size = 0;
        while (temp != null) {
            if (++size == k) {
                break;
            }
            temp = temp.next;
        }
        int tempVal = temp.val;
        temp.val = ptr.val;
        ptr.val = tempVal;
        return head;
    }
}