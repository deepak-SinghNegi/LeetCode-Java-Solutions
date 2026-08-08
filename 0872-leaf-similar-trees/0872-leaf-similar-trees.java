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
    List<Integer> vals = new ArrayList<>();

    int i = 0;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1);
        return isSimiler(root2) && i == vals.size();
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            vals.add(root.val);
        }
        dfs(root.left);
        dfs(root.right);
    }

    private boolean isSimiler(TreeNode root) {
        if (i >= vals.size())
            return false;
        if (root.left == null && root.right == null) {

            if (root.val != vals.get(i++))
                return false;
            return true;
        }
        boolean leftCheck = true;
        if (root.left != null)
            leftCheck = isSimiler(root.left);
        boolean rightCheck = true;
        if (root.right != null)
            rightCheck = isSimiler(root.right);
        return leftCheck && rightCheck;
    }
}