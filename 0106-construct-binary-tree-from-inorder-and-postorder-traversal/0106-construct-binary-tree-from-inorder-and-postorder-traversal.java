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
    int poi = 0;
    Map<Integer , Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for(int i = 0; i < n; i++){
            map.put(inorder[i] , i);
        }
        poi = n-1;
        return buildTreeUtil(inorder , postorder , 0 , n-1);
    }
    private TreeNode buildTreeUtil(int [] inorder , int[] postorder , int left , int right){
        if(left > right) return null;
        int rootVal = postorder[poi--];
        TreeNode root = new TreeNode(rootVal);
        int ioi = map.get(rootVal);
        root.right = buildTreeUtil(inorder , postorder , ioi + 1 , right);
        root.left = buildTreeUtil(inorder , postorder , left , ioi - 1);
        return root;
    }
}