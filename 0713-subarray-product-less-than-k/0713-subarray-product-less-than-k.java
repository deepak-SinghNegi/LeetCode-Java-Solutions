class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0) return 0;
        int count = 0;
        
        int left = 0;
        int right = 0;
        int currProd = 1;
        while(right < nums.length){
            
            currProd *= nums[right];
            while(currProd >=k){
                if(left<nums.length)
                currProd /= nums[left++];
                else return count;
                
                
            }
            count  += right - left +1; 
            right++;
            
        }
       
        return count ;
    }
}