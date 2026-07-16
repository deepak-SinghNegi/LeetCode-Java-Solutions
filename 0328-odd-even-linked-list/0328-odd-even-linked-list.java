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
    public ListNode oddEvenList(ListNode head) {
        if(head == null ) return null;
        if(head.next == null) return head;
        ListNode oddPtr = head;
        ListNode evenPtr = head.next;
        ListNode firstEven = evenPtr;
        while(oddPtr.next != null && oddPtr != null && evenPtr.next != null && evenPtr != null){

            oddPtr.next = evenPtr.next;
            oddPtr = oddPtr.next;
            evenPtr.next = evenPtr.next.next;
            evenPtr = evenPtr.next;
        }
        oddPtr.next = firstEven;
        return head;
    }
}