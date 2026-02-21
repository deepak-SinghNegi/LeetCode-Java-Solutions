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
    public void reorderList(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode prev = head;
        ListNode temp = slow;
        while(temp!=null){
            st.push(temp);
            temp = temp.next;
        }
        // System.out.println(st.pop().val);
        // System.out.println(st.peek().val);
        
        while(!st.isEmpty()&&st.peek()!= prev){
            ListNode next = prev.next;
            prev.next = st.peek();
            st.pop().next = next;
            prev = next;
        }
        slow.next =null;

    }
}