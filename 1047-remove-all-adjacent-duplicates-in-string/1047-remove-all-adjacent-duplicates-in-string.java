class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        char[] ch = s.toCharArray();
        for (char x : ch) {
            if (st.isEmpty())
                st.push(x);
            else if (x == st.peek())
                st.pop();
            else
                st.push(x);
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
            sb.insert(0, st.pop());
        return sb.toString();
    }
}