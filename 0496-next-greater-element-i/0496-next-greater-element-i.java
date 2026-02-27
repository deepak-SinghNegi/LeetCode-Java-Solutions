class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int m = nums1.length;
        int[] nge = new int[n];
        int[] ans = new int[m];
        Arrays.fill(nge, -1);
        Deque<Integer> st = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {

            map.put(nums2[i], i);

            while (!st.isEmpty() && nums2[st.peek()] <= nums2[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? -1 : nums2[st.peek()];
            st.push(i);
        }
        for (int i = 0; i < m; i++) {
            ans[i] = nge[map.get(nums1[i])];
        }
        return ans;
    }
}