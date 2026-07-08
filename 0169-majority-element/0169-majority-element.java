class Solution {
    public int majorityElement(int[] nums) {
      
        int x = 0;
        for(int i = 0;i<nums.length && x < nums.length;i++){
            if(nums[x] != nums[i]){
                nums[x] = nums[i] = -1;
                while(nums[x] ==-1)x++;
            }
        }
        int ans = -1;
        for(int y : nums){
            if(y!=-1){
                ans = y;
                break;
            }
        }
        return ans;
    }
}