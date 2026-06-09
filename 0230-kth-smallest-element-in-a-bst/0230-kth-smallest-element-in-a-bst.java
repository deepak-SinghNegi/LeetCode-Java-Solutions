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
    int c = 0;
    int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        helper(root , k);
        return ans;
    }

    private void helper(TreeNode root , int k) {
        if (root != null) {
            helper(root.left , k);
            c++;
            if (c == k)
                ans = root.val;
            else {
                helper(root.right , k);
            }
        }

    }
}