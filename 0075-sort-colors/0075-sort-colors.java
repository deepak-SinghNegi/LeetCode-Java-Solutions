class Solution {
    public void sortColors(int[] nums) {
       int[] arr = new int [3];
       for(int i=0;i<nums.length;i++){
        arr[nums[i]]++;
       } 
       int j= 0;
       for(int i=0  ;i<arr.length;i++){
        Arrays.fill(nums,j,arr[i]+j,i);
        j+=arr[i];
       }
       
    }
}