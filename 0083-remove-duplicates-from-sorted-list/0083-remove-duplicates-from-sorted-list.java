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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode left = head;
        ListNode right = head;
        while(right!=null){
            if(right.val==left.val){
                right = right.next;
            }
            else{
                left.next = right;
                left = right;
            }
        }
        if(right==null && left!=null){
            left.next = null;
        }
        return head;
    }
}