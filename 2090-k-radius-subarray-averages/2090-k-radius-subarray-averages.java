class Solution {
    public int[] getAverages(int[] nums, int k) {
        
        int [] ans = new int[nums.length];
        Arrays.fill(ans,-1);
        if (k == 0) return nums;                 
        if (nums.length < 2 * k + 1) return ans;
        long  sum = 0;
        for(int i = 0;i<=2*k;i++){
            sum+=nums[i];
        }
        ans[k] = (int)(sum / (2 * k + 1)); 
        for(int i=k+1;i<nums.length-k;i++){
            // if(i<k||i>2*k){
            //     ans[i]=-1;
            //     continue;
            // }
            // if(i==k)ans[i]=average;
            // else{
                sum = (sum-nums[i-k-1])+nums[i+k];
                ans[i] =(int) (sum/(2*k+1));
            // }
        }
        return ans;
    }
}