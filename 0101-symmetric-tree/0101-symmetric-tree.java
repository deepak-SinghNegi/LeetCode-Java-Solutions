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
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return true;
        return mirror(root.left, root.right);
    }

    private boolean mirror(TreeNode lst, TreeNode rst) {
        if (lst == null && rst == null)
            return true;
        if (lst == null || rst == null)
            return false;
        return lst.val == rst.val && mirror(lst.left, rst.right) && mirror(lst.right, rst.left);

    }
}