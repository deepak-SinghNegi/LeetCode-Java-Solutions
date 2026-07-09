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
    int maxPath = -1001;
    public int maxPathSum(TreeNode root) {
        maxPahSumUtil(root);
        return maxPath;
        
    }
    private int maxPahSumUtil(TreeNode root){
      
        if(root == null) return 0;
        int left =Math.max(0 ,  maxPahSumUtil(root.left));
        int right = Math.max(maxPahSumUtil(root.right) , 0);
        maxPath = Math.max(left + right + root.val , maxPath);
        return  Math.max(left , right) + root.val;
        
        
    }
}