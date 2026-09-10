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
    int count = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }

    private int[] dfs(TreeNode root) {
        if (root == null)
            return new int[] { 0, 0 };
        int curr1[] = dfs(root.left);
        int curr2[] = dfs(root.right);
        int sum = curr1[0] + curr2[0] + root.val;
        int nodes = curr1[1] + curr2[1] + 1;
        if (root.val == sum / nodes)
            count++;
        return new int[] { sum, nodes };

    }
}