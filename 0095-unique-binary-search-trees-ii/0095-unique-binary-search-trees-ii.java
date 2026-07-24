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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();   // FIX (optional for LeetCode)
        return generateTreesUtil(1, n);
    }

    private List<TreeNode> generateTreesUtil(int s, int e) {

        
        if (s > e) {
            List<TreeNode> res = new ArrayList<>();
            res.add(null);
            return res;
        }

        List<TreeNode> res = new ArrayList<>();

     
        for (int i = s; i <= e; i++) {

            List<TreeNode> leftBsts = generateTreesUtil(s, i - 1);

            List<TreeNode> rightBsts = generateTreesUtil(i + 1, e);

            for (TreeNode leftRoot : leftBsts) {
                for (TreeNode rightRoot : rightBsts) {

                    TreeNode root = new TreeNode(i);

                    root.left = leftRoot;
                    root.right = rightRoot;

                    res.add(root);
                }
            }
        }

        return res;
    }
}