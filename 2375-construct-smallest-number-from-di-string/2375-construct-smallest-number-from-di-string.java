class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> st = new Stack<>();
        int n = pattern.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            st.push(i + 1);
            if ((i == n || pattern.charAt(i) == 'I')) {
                while (!st.isEmpty())
                    sb.append(Integer.toString(st.pop()));
            }
        }
        return sb.toString();
    }
}