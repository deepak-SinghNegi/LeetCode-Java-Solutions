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
    public int countNodes(TreeNode root) {
        int lmax = leftHeight(root);
        int rmax = rightHeight(root);
        if(lmax == rmax){
            return(int) Math.pow(2 , lmax) -1;
        }
        else{
            return countNodes(root.left) + countNodes(root.right) +1;
        }
      
    }
    private int rightHeight(TreeNode root){
        TreeNode temp = root;
        int c = 0;
        while(temp != null){
            temp = temp.right;
            c ++;
        }
        return c;
    }
    private int leftHeight(TreeNode root){
        TreeNode temp = root;
        int c = 0;
        while(temp != null){
            temp = temp.left;
            c ++;
        }
        return c;
    }
}