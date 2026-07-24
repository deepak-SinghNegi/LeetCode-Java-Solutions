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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        ListNode temp = head;
        while(temp!=null){
            if(temp.val < x){
                ListNode node = new ListNode(temp.val);
                ptr.next = node;
                ptr = node;
            }
            temp = temp.next;
        }
        
        temp = head;
        while(temp!=null){
            if(temp.val >= x){
                ListNode node = new ListNode(temp.val);
                ptr.next = node;
                ptr = node;
            }
            temp = temp.next;
        }
       
        return dummy.next;
    }
}