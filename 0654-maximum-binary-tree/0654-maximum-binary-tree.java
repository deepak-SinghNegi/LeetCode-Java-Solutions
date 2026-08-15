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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return util(nums, 0, nums.length - 1);
    }

    private TreeNode util(int nums[], int s, int e) {
        if (e < s)
            return null;

        int max = -1;
        int idx = -1;
        for (int i = s; i <= e; i++) {
            if (max < nums[i]) {
                max = nums[i];
                idx = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = util(nums, s, idx - 1);
        root.right = util(nums, idx + 1, e);
        return root;
    }
}