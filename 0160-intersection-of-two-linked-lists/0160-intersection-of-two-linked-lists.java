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
        ListNode a = headA;
        ListNode b = headB;
        int sizeA = 0;
        int sizeB = 0;
        while (a != null || b != null) {
            if (a != null) {
                sizeA++;
                a = a.next;
            }
            if (b != null) {
                sizeB++;
                b = b.next;
            }
        }
        a = headA;
        b = headB;
        while (sizeA != sizeB) {
            if (sizeA < sizeB) {
                b = b.next;
                sizeB--;
            } else if (sizeB < sizeA) {
                a = a.next;
                sizeA--;
            }
        }
        while (a != null) {
            if (a == b)
                return a;
            a = a.next;
            b = b.next;
        }
        return null;
    }
}