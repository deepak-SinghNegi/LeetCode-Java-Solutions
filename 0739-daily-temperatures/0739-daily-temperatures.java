class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] ans = new int [n];
        Stack<Integer> st = new Stack<>();
        Stack<Integer> st1 = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && temperatures[i]>=st.peek()){
                st.pop();
                st1.pop();
            }
            ans[i] = st.isEmpty() ? 0 : st1.peek() - i;

            st.push(temperatures[i]);
            st1.push(i);
        }
        return ans;
    }
}