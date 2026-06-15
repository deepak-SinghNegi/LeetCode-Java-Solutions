class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        helper(sb, ans, root);

        return ans;
    }

    private void helper(StringBuilder sb, List<String> list, TreeNode root) {

        int len = sb.length();

        sb.append(root.val);

        if(root.left == null && root.right == null) {
            list.add(sb.toString());
        }
        else {
            sb.append("->");

            if(root.left != null)
                helper(sb, list, root.left);

            if(root.right != null)
                helper(sb, list, root.right);
        }

        sb.delete(len, sb.length());
    }
}