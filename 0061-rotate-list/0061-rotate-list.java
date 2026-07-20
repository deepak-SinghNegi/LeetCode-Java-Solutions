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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)return null;
        if(k == 0 || head.next == null) return head;
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        k %= size;
        if(k == 0) return head;
        int rIndex = size - k-1;
        ListNode rotateNode = head;
        while (rotateNode != null && rIndex > 0) {
            rotateNode = rotateNode.next;
            rIndex--;
        }
        System.out.print(rotateNode.val);
        ListNode next = rotateNode.next;
        temp = next;
        rotateNode.next = null;
        while (next.next != null) {
            next = next.next;
        }
        next.next = head;
        head = temp;
        return head;
    }
}