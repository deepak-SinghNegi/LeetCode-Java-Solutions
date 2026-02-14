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
        char [] arr = new char[st.size()];
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = st.pop();
        }
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}