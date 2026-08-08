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
    public int pairSum(ListNode head) {
        int maxSum = 0;
        ListNode slow = null;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            if (slow == null)
                slow = head;
            else
                slow = slow.next;
            fast = fast.next.next;

        }
        ListNode prev = null;
        ListNode curr = slow.next;
        ListNode next = null;
        slow.next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        while (prev != null) {
            maxSum = Math.max(maxSum, prev.val + head.val);
            head = head.next;
            prev = prev.next;
        }
        return maxSum;
    }
}