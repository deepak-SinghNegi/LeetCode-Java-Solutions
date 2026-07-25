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
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root , 0);
        return totalSum;
    }
    private void dfs(TreeNode root , int digit){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            digit *=10;
            digit += root.val;
            totalSum +=digit;
            return;
        }
        dfs(root.left , digit*10 + root.val);
        dfs(root.right , digit*10 + root.val);
    }
}