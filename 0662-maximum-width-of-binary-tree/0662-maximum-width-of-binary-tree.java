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
    int h = -1;

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[] { root, 0L });
        int maxWidth = 0;
        while (!q.isEmpty()) {
            int currWidth = 0;
            long firstNode = 0;
            long lastNode = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Object[] curr = q.poll();
                TreeNode parent = (TreeNode)curr[0];
                Long idx = (Long)curr[1];
                if (i == 0)
                    firstNode = idx;
                if (i == size - 1)
                    lastNode = idx;
                if (parent.left != null)
                    q.add(new Object[] { parent.left, idx * 2 + 1 });
                if (parent.right != null)
                    q.add(new Object[] { parent.right, idx * 2 + 2 });
            }
            h++;
            currWidth = (int)(lastNode - firstNode + 1);
            maxWidth = Math.max(currWidth, maxWidth);

        }
        return maxWidth;
    }
}