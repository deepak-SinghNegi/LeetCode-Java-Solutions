class Solution {
    public long subArrayRanges(int[] nums) {
        long total = 0;
        int i = 0;
        int j = 1;
        int max = 0;
        int min = 0;
        
        while(i<nums.length-1){
            max = Math.max(nums[i],nums[j]);
            min = Math.min(nums[i],nums[j]);
            while(j<nums.length){
                max = Math.max(max,nums[j]);
                min = Math.min(min,nums[j]);
                total += (max - min);
                
                j++;
            }
            i++;
            j=i+1;
        }
        return total;
    }
}