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
    int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
        return maxPath;
    }

    private int maxPathSumUtil(TreeNode root) {
        if (root == null)
            return 0;
        int lPath = root.val + Math.max(0, maxPathSumUtil(root.left));
        int rPath = root.val + Math.max(0, maxPathSumUtil(root.right));
        int maxChiledPath = Math.max(lPath, rPath);
        maxPath = Math.max(Math.max(lPath+rPath-root.val, root.val), maxPath);
        return Math.max(maxChiledPath, root.val);

    }
}