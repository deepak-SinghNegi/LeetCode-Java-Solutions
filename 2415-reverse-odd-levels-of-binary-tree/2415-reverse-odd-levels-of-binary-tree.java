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
    public TreeNode reverseOddLevels(TreeNode root) {
        
        helper(root.left,root.right , 1);
        return root;
    }
    private void helper(TreeNode lst , TreeNode rst ,  int h){
        if(lst ==null || rst==null)return;

        if(h%2!=0){
            int temp = rst.val;
            rst.val = lst.val;
            lst.val= temp;
    
        }
        helper(lst.left , rst.right , h+1);
        helper(lst.right , rst.left , h+1);


    }
}