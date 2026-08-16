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
    Set<Integer> set = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set.add(0);
        for (int val : to_delete) {
            set.add(val);
        }
        List<TreeNode> ans = new ArrayList<>();
        TreeNode newRoot = new TreeNode(0, root, null);

        dfs(newRoot, ans);
        return ans;
    }

    private void dfs(TreeNode root, List<TreeNode> ans) {
        if (root == null)
            return;

        if (set.contains(root.val)) {
            TreeNode left = createTree(root.left);
            if (left != null)
                ans.add(left);
            TreeNode right = createTree(root.right);
            if (right != null)
                ans.add(right);
        }

        dfs(root.left, ans);
        dfs(root.right, ans);

    }

    private TreeNode createTree(TreeNode root) {
        if (root == null)
            return null;
        if (set.contains(root.val))
            return null;
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = createTree(root.left);
        newRoot.right = createTree(root.right);
        return newRoot;
    }
}