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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        vtUtil(root, map, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> inMap : map.values()) {
            List<Integer> list = new ArrayList<>();
            for (PriorityQueue<Integer> pq : inMap.values()) {
                while (!pq.isEmpty())
                    list.add(pq.poll());
            }
            res.add(list);
        }
        return res;
    }

    private void vtUtil(TreeNode root, Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, int hi, int vi) {
        if (root == null)
            return;

        if (!map.containsKey(hi)) {
            map.put(hi, new TreeMap<>());
        }
        if (!map.get(hi).containsKey(vi)) {
            map.get(hi).put(vi, new PriorityQueue<>());
        }
        map.get(hi).get(vi).add(root.val);
        vtUtil(root.left, map, hi - 1, vi + 1);
        vtUtil(root.right, map, hi + 1, vi + 1);
    }
}