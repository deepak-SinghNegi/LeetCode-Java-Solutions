class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor = nums[0];
        boolean flag = nums[0] !=0;
        for(int i = 1; i< n;i++){
            if(!flag && nums[i] !=0)flag = true;
                xor ^= nums[i];
        }
        if(xor != 0)
            return n;
        else if(xor == 0 && flag)
            return n-1;
        else
            return 0;
    }
}