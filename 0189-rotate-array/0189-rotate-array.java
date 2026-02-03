class Solution {
    public void rotate(int[] nums, int k) {
        int [] ans = new int [nums.length];
        while(nums.length<k){
            k = Math.abs(nums.length-k);
        }
        int i = nums.length-k;
        int j = 0;
        if(nums.length<=1)return;
        while(i<nums.length){
            ans[j] = nums[i];
            i++;
            j++;
        }
        i =0;
        while(i<nums.length-k){
            ans[j] = nums[i];
            i++;
            j++;
        }
        for(int l =0;l<ans.length;l++){
        nums[l] = ans[l];
       }
    }
}