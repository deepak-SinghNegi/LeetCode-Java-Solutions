class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int kval = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i>=0;i--){
            if(nums[i] < kval)return true;
            while(!st.isEmpty() && nums[i] > st.peek()){
                kval = st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }
}