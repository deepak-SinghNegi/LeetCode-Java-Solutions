/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        Node copy = new Node(-1);
        Node ptr =copy;
        HashMap<Node,Integer> map = new HashMap<>();
        int i =0;
        while(temp!=null){
            map.put(temp,i++);
            copy.next = new Node(temp.val);
            copy =copy.next;
            temp = temp.next;
            // copy.next.next = temp.next;
            // copy.next.random = temp.random; 
        }
        copy = ptr.next;
        temp =head;
        
        while(copy!=null){
            if(temp.random==null){
                copy.random = null;
                temp = temp.next;
                copy = copy.next;
                continue;
            }
            int j = 0;
            Node temp1 = ptr.next;
            while(map.get(temp.random)!=j){
                temp1 = temp1.next;
                j++;
            }
            copy.random = temp1;
            copy = copy.next;
            temp = temp.next;

            
        }
        
        return ptr.next;
    }
}