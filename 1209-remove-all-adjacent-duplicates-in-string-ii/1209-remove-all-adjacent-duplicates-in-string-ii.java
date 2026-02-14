class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> st = new Stack<>();
        Stack<Integer> count = new Stack<>();

        char[] ch = s.toCharArray();
        for (char x : ch) {
            if (st.isEmpty()) {
                st.push(x);
                count.push(1);
            }

            else if (x != st.peek()) {
               
                st.push(x);
                count.push(1);

            } else {
               
                st.push(x);
                count.push(count.peek() + 1);
              
            }
            
            if (count.peek() ==k) {
                int i = 0;
                while (i <k) {
                    if(!st.isEmpty()){
                        st.pop();
                        count.pop();
                    }   
                    i++;
                }

            }

        }
        char[] result = new char[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        return new String(result);
    }
}