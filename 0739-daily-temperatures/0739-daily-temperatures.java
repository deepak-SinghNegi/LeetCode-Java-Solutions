class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] ans = new int [n];
       
        Stack<Integer> st1 = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st1.isEmpty() && temperatures[i]>=temperatures[st1.peek()]){
                
                st1.pop();
            }
            ans[i] = st1.isEmpty() ? 0 : st1.peek() - i;

          
            st1.push(i);
        }
        return ans;
    }
}