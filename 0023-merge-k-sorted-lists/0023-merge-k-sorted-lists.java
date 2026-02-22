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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        if(lists.length==1)return lists[0];
        ListNode dummy = new ListNode();
       
        ListNode dptr = dummy;
        
        ListNode list1 = lists[0];
        for(int i=1;i<lists.length;i++){
            while(list1!=null && lists[i]!=null){
                if(list1.val<=lists[i].val){
                    dptr.next = list1;
                    dptr = dptr.next;
                    list1 = list1.next;

                }
                else{
                    dptr.next = lists[i];
                    dptr = dptr.next;
                    lists[i] = lists[i].next;
                }
            }
            while(list1!=null){
                dptr.next = list1;
                dptr = dptr.next;
                list1 = list1.next;
            }
            while(lists[i]!=null){
                dptr.next = lists[i];
                dptr = dptr.next;
                lists[i] =lists[i].next;

            }
            list1 = dummy.next;
            dptr= dummy;
        }
        return dummy.next;
    }
}