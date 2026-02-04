class Solution {
    public int maximumGap(int[] nums) {
        // if(nums.length==1)return 0;
        // int max = Integer.MIN_VALUE;
        // for(int i=0;i<nums.length;i++){
        //     max = Math.max(nums[i],max);
        // }
        // int[] arr = new int [max+1]; 
        // for(int i =0;i<nums.length;i++){
        //     arr[nums[i]]++;
        // }
        // int maxDiff =0;
        // int lPtr=0;
        // while(nums[lPtr]!=1){
        //     lPtr++;
        // }
        // int rPtr = lPtr;
        // while(rPtr<arr.length){
        //     if(arr[rPtr] == 1){
        //         maxDiff = Math.max(maxDiff,rPtr-lPtr);
        //         lPtr = rPtr;
        //         rPtr++;
        //     }
        //     else{
        //         rPtr++;
        //     }
        // }

    //    return maxDiff; 
    Arrays.sort(nums);
    int maxDiff = 0;

    for(int i=0;i<nums.length-1;i++){
        maxDiff = Math.max(maxDiff,nums[i+1]-nums[i]);
    }
    return maxDiff;
    }
}