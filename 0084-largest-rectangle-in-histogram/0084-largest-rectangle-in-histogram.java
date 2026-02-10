class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] nsl = new int[n];
        int[] nsr = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nsl[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }
        st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nsr[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int w = nsr[i] - nsl[i] - 1;
            maxArea = Math.max(h * w, maxArea);

        }
        return maxArea;
    }
}