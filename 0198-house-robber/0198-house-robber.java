
import java.util.Scanner;

class Solution {
    public int robbing(int[] nums , int i){
        if(i>=nums.length)return 0;
        int steal =nums[i] + robbing(nums, i+2); 
        int skip = robbing(nums, i+1); 
        return Math.max(skip,steal);
    }
    public int rob(int[] nums) {
        // int [] Dp = new int[nums.length+1];
        // Arrays.fill(Dp, -1);
        return robbing(nums, 0);
    }
}


