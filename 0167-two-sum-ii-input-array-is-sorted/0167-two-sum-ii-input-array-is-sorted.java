class Solution {
    public int[] twoSum(int[] nums, int t) {
        int i = 0;
        int j = nums.length - 1;
        while(j>i){
            if(nums[j]+nums[i] == t)
                break;
            else if(nums[j]+nums[i] > t)
                j--;
            else
                i++;
            
        }
       return new int []{i+1 , j+1};
    }
}