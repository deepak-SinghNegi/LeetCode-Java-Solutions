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

        List<List<Integer>> res = new ArrayList<>();

        vtUtil(map, root, 0, 0);

        for (TreeMap<Integer, PriorityQueue<Integer>> smap : map.values()) {
            List<Integer> x = new ArrayList<>();
            for (PriorityQueue<Integer> pq : smap.values()) {
               
                while (!pq.isEmpty()) {
                    x.add(pq.poll());
                }
            }
            res.add(x);
        }

        return res;
    }

    private void vtUtil(Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, TreeNode root, int i, int j) {
        if (root == null)
            return;

        if (!map.containsKey(i))
            map.put(i, new TreeMap<>());

        if (!map.get(i).containsKey(j))
            map.get(i).put(j, new PriorityQueue<>());

        map.get(i).get(j).offer(root.val);

        vtUtil(map, root.left, i - 1, j + 1);
        vtUtil(map, root.right, i + 1, j + 1);
    }
}