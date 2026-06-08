/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        boolean flag = false;
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            Stack<Integer> st = new Stack<>();
            while(q.peek() !=null){
                TreeNode curr = q.remove();
                if(flag){
                    st.push(curr.val);
                }
                else{
                    list.add(curr.val);
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            flag = !flag;
            q.remove();
            while(!st.isEmpty()){
                list.add(st.pop());
            }
            ans.add(list);
            if(q.isEmpty()) break;
            q.add(null);

        }
        return ans;
    }
}