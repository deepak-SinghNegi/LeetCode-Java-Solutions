class Solution {
    public int maxProduct(int[] nums) {
   
        int res = Integer.MIN_VALUE;
        int currMax =1;
        int currMin = 1;
        for(int n : nums){
            int possMin = Math.min(n , currMax*n);
            int possMax = Math.max(n , currMin*n);
            currMax = Math.max(currMax*n , possMax);
            currMin = Math.min(currMin*n , possMin);
            res = Math.max(res , currMax);
        }
        return res;
    }
}
  