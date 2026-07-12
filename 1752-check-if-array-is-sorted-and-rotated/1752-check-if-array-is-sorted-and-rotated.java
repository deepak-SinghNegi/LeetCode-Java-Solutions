class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int x = 0;
        for(int i = 1; i<n;i++){
            if(nums[i] <nums[i-1]){
                x++;
            }
            if(x>1)break;
        }
        if (x>1) return false;
            if(x== 1){
               return  (nums[n-1] <= nums[0]) ? true:false;
            }
        return x==0 ? true: false;

    }
}