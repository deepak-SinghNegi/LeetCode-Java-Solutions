class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        st.push(Integer.parseInt(tokens[0]));
        int i = 0;
        while(i < tokens.length){
            if(!(tokens[i].equals("+") || tokens[i].equals("-")||tokens[i].equals("*")|| tokens[i].equals("/"))){
                st.push(Integer.parseInt(tokens[i]));
            }
            else{
                int x = st.pop();
                int y = st.pop();
                if(tokens[i].equals("+")){
                    st.push(x + y);
                }
                else if(tokens[i].equals("-")){
                    st.push(y - x);
                }
                else if(tokens[i].equals("*")){
                    st.push(x * y);
                }
                else{
                    st.push( y/x);
                }
            }
            i++;
        }
        return st.peek();
    }
}