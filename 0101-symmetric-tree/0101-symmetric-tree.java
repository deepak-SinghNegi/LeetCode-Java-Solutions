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
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        else if (root.left == null || root.right == null) return false;
        else{
            return mirror( root.left , root.right);
        }
    }
    private boolean mirror(TreeNode lst , TreeNode rst){
        if(lst == null && rst == null) return true;
        else if(lst == null || rst == null) return false;
        else{
            return lst.val == rst.val && mirror(lst.left , rst.right) && mirror(lst.right , rst.left);
        }
    }
}