class Solution {
    public int maxProduct(int[] nums) {
        int maxPro = nums[0];
        int minPro = nums[0];
        int result = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int temp = maxPro;
                maxPro = minPro;
                minPro = temp;
            }
            maxPro = Math.max(nums[i],nums[i]*maxPro);
            minPro = Math.min(nums[i],nums[i]*minPro);

            result = Math.max(maxPro,result);

        }
        return result;
    }
}