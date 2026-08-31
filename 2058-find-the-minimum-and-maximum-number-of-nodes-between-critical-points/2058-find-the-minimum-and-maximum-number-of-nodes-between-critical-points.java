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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int res [] = new int[]{-1 , -1};
        if(head.next.next == null)return res;
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;
        int idx = 2;
        List<Integer> list = new ArrayList<>();
        while(next !=null){

            if((curr.val < prev.val && curr.val < next.val)|| (curr.val > prev.val && curr.val > next.val))
                list.add(idx);
            prev = curr;
            curr = next;
            next = next.next;
            idx++;
        }
        if(list.size() <= 1) return new int[]{-1 , -1};
        res[1] = list.get(list.size() -1) - list.get(0);
        res[0] = res[1];
        for(int i = 1; i<list.size();i++){
            
            res[0] = Math.min(res[0] , list.get(i) - list.get(i-1));
        }
        return res;
    }
}