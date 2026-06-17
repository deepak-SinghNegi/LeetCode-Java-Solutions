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
    boolean diff = true;
    public boolean isBalanced(TreeNode root) {
        if (root ==null) return true;
        check(root);
        if(diff){
            return true;
        }
        else return false;
    }
    private int check(TreeNode root){
        if(root == null) return 0;

        int lh = check(root.left);
        int rh = check(root.right);
        if(diff) diff = Math.abs(lh - rh) >1 ? false: true;
        return Math.max(lh , rh) +1;
    }
}