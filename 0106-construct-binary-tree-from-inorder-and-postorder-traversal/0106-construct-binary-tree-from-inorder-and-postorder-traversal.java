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
    int posIndex =0; 
    Map<Integer , Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        posIndex = n-1;
        for(int i = 0; i<n;i++){
            map.put(inorder[i] , i);
        }
        return buildTree(inorder , postorder , 0 ,n-1);
    }
    private TreeNode buildTree(int [] inord , int []postord , int s , int e){
        if(s > e) return null;
        int val = postord[posIndex--];
        TreeNode root = new TreeNode(val);
        int inIndex = map.get(val);
        root.right = buildTree(inord , postord , inIndex + 1 , e );
        root.left = buildTree(inord , postord  , s , inIndex - 1 );
        return root;
    }
}