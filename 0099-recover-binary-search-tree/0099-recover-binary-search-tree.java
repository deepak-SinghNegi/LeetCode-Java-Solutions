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
    TreeNode ptr1 = null;
    TreeNode ptr2 = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        recoverTreeUtil(root);
        int temp = ptr1.val;
        ptr1.val = ptr2.val;
        ptr2.val = temp;
        
    }
    private void recoverTreeUtil(TreeNode root){
        if(root == null) return;
        
        recoverTreeUtil(root.left);
        if(prev!=null && root.val < prev.val){
            if(ptr1 == null){
               
                ptr1 = prev;
            } 
            ptr2 = root;
            
        }
        prev = root;
        recoverTreeUtil(root.right);
    }
    
}