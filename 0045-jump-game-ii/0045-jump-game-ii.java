class Solution {
    public int jump(int[] nums) {
        if(nums.length==1)return 0;
        int maxJump = 0;
        int left = 0;
        int counter = 0;
        for(int right = 0;right<nums.length-1;right++){
           
                maxJump = Math.max(maxJump,nums[right]+right);
                if(left==right) {
                    counter++;
                    left = maxJump;

                }
            
        }
        return counter;

    }
}