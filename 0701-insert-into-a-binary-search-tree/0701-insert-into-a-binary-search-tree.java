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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return helper(root , val);
    }
    private TreeNode helper(TreeNode root , int val){
        if(root == null) root = new TreeNode(val);
        else if(root.val > val){
            root.left = helper(root.left , val);
        }
        else if(root.val < val){
            root.right = helper(root.right , val);
        }
        return root;
    }
}