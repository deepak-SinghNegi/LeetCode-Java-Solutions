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
    int n = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int preIdx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        n = preorder.length;

        int inorder[] = new int[n];
        for (int i = 0; i < n; i++) {

            inorder[i] = preorder[i];
        }
        Arrays.sort(inorder);
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return util(inorder, preorder, 0, n - 1);
    }

    private TreeNode util(int[] inorder, int[] preorder, int si, int ei) {
        if (si > ei)
            return null;
        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);
        int idx = map.get(rootVal);
        root.left = util(inorder, preorder, si, idx - 1);
        root.right = util(inorder, preorder, idx + 1, ei);
        return root;
    }
}