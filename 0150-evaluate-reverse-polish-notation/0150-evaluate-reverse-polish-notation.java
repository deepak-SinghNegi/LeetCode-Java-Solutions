class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String s : tokens) {
            int temp;
            switch (s) {
                case "+":
                     temp = st.pop();
                    temp += st.peek();
                    st.pop();
                    st.push(temp);
                    break;
                case "-":
                     temp = st.pop();
                    temp = st.peek() - temp;
                    st.pop();
                    st.push(temp);
                    break;
                case "*":
                     temp = st.pop();
                    temp *= st.peek();
                    st.pop();
                    st.push(temp);
                    break;
                case "/":
                     temp = st.pop();
                   temp =  st.peek()/ temp;
                   st.pop();
                    st.push(temp);
                    break;
                default:
                    st.push(Integer.parseInt(s));

            }
        }
        return st.peek();
    }
}