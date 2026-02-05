class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int [] ans = new int [n];
        int j=0;
        
        for(int i=0;i<n;i++){
            
           j = nums[i];
           if(nums[i]==0){
                ans[i] = nums[i];
            }
           
                int x = (i+j)%n+n;
                
                ans[i] = nums[x%n];
            
            
        }

        return ans;
    }
}