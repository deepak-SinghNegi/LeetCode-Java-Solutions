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
       
        Map<Integer, Integer> map = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            map.put(temp.val, map.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }
        ListNode curr = new ListNode(0);
        ListNode newHead = curr;
        temp = head;
        while (temp != null) {
            System.out.println(temp.val + " " + map.get(temp.val));
            if (map.get(temp.val) == 1) {
                curr.next = temp;
                curr = temp;
            }
            temp = temp.next;
        }
        if (curr != null)
            curr.next = null;

        return newHead.next;
    }
}