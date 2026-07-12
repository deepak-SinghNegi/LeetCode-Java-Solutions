class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int [] left = new int[n];
        int right[] = new int[n];
        left[0] = nums[0];
        right[n-1] = nums[n-1];
        int pivot = -1;
        for(int i = 1;i<n;i++){
            left[i] = left[i-1]+nums[i];        
        }
        if(right[n-1] == left[n-1])pivot = n-1;
        for(int i = n-2;i>=0;i--){
            right[i] = right[i+1]+nums[i];
            if(right[i] == left[i]) pivot = i;
        }
        return pivot;
    }
}