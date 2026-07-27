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
    public int[] nextLargerNodes(ListNode head) {
        
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
           
        }
        int res[] = new int[list.size()];
       
        Stack<Integer> st = new Stack<>();
        
        temp = head;
        for (int i = 0; i < list.size(); i++) {
            while (!st.isEmpty() && list.get(i) > list.get(st.peek())) {
                int j = st.pop();
                res[j] = list.get(i);
            }
            st.push(i);
        }
        return res;
    }
}