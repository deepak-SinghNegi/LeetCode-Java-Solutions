class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();

        char[] chArr = s.toCharArray();
        for (char ch : chArr) {
            if (ch != ']') {
                st.push(ch);
            }

            else {
                StringBuilder sb = new StringBuilder();
                while (!st.isEmpty() && st.peek() != '[') {
                    sb.append(st.pop());
                }
                if (!st.isEmpty())
                    st.pop();

                int num = 0;
                int temp = 1;
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    num += temp * (st.peek() - '0');
                    temp *= 10;
                    st.pop();
                }
                while (num != 0) {
                    for (int i =  sb.length()-1; i >=0; i--) {
                        st.push(sb.charAt(i));
                    }
                    num--;

                }

            }
        }
        char[] result = new char[st.size()];
        for (int i = result.length-1; i >=0 ; i--) {
            result[i] = st.pop();
        }
        String ans = new String(result);
        return ans;
    }
}