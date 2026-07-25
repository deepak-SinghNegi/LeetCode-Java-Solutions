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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPaths = new ArrayList<>();

        findPath(root, allPaths, new ArrayList<>(), targetSum, 0);

        return allPaths;
    }

    private void findPath(TreeNode root, List<List<Integer>> res, List<Integer> list, int tg, int sum) {

        if (root == null)
            return;

        if (root.left == null && root.right == null) {

            list.add(root.val);

            sum += root.val;

            if (tg == sum)
                res.add(new ArrayList<>(list));

            list.remove(list.size() - 1);

            return;
        }

        list.add(root.val);

        findPath(root.left, res, list, tg, sum + root.val);

        findPath(root.right, res, list, tg, sum + root.val);

        list.remove(list.size() - 1);

    }
}