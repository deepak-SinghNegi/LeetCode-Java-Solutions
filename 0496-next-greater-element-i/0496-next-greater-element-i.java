class Solution{

    public int[] nextGreaterElement(int nums1[] ,int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        st.push(nums2[nums2.length-1]);
        int [] nextGr = new int[nums2.length];
        nextGr[nextGr.length-1] = -1;
        int [] ans =  new int [nums1.length];

        for(int i = nums2.length-2; i>= 0;i--){
            while(!st.isEmpty()&&st.peek()<=nums2[i]){
                st.pop();

            }


            if(!st.isEmpty())nextGr[i] = st.peek();
            else nextGr[i] = -1;
            st.push(nums2[i]);


        }
        for(int i = 0; i<nums2.length;i++){
            map.put(nums2[i],nextGr[i]);
        }
        for(int i=0;i<nums1.length;i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}