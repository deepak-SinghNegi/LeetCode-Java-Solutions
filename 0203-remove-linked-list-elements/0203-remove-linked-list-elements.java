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
    public ListNode removeElements(ListNode head, int val) {
        ListNode  dummy = new ListNode();
        ListNode ptr = dummy;
        while(head!=null){
            if(head.val!=val){
                ptr.next = head;
                ptr = ptr.next;
                
            }
            else{
               
                ptr.next = null;
            }
           
            head = head.next;
            
        }
       dummy =dummy.next;
        return dummy;
    }
}