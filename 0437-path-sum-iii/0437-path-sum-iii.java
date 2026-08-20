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
    Map<Long, Integer> map = new HashMap<>();
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)return 0;
        map.put(0L , 1);
        dfs(root, targetSum, 0L);
        return count;
    }

    private void dfs(TreeNode root, int targetSum, long sum) {
        if (root == null)
            return;
        sum +=root.val;
        long key =  sum - targetSum;
        if (map.containsKey(key)) {
            count += map.get(key);
        } 
            map.put(sum, map.getOrDefault(sum , 0)+1);
        
        dfs(root.left, targetSum, sum);
        dfs(root.right, targetSum, sum);
        map.put(sum , map.get(sum)-1);
        
        
    }
}