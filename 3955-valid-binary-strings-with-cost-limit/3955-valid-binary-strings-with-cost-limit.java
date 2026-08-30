class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateValidStrings(int n, int k) {
        StringBuilder sb = new StringBuilder();
        helper(sb, n, k, 0);
        return res;
    }

    private void helper(StringBuilder sb, int n, int k, int sum) {
        if (sb.length() == n) {
            if (sum <= k)
                res.add(sb.toString());
            return;
        }
        sb.append('0');
        helper(sb, n, k, sum);
        sb.deleteCharAt(sb.length() - 1);
        if (sb.length() == 0) {
            sb.append('1');
            helper(sb, n, k, sum + sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        } else if (sb.charAt(sb.length() - 1) != '1') {
            sb.append('1');
            helper(sb, n, k, sum + sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}