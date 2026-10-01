class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char chr = s.charAt(0);
        st.push(chr);
        for (int i = 1; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (ch == '[')
                chr = ']';
            else if (ch == ']')
                chr = '[';
            else if (ch == '{')
                chr = '}';
            else if (ch == '}')
                chr = '{';
            else if (ch == '(')
                chr = ')';
            else if (ch == ')')
                chr = '(';
            if (st.isEmpty())
                st.push(ch);
            else if (st.peek() == ']' || st.peek() == ')' || st.peek() == '}')
                return false;
            else if (st.peek() == chr)
                st.pop();

            else
                st.push(ch);

        }
        return st.isEmpty();
    }
}