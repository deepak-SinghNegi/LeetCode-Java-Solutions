class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] freq  = new int [nums.length+1];
        int [] ans = new int [2];
        for(int i = 0;i<nums.length;i++){
            freq[nums[i]]++;
            if(freq[nums[i]]==2)ans[0] = nums[i];

        }
        for(int i=1;i<freq.length;i++){
            if(freq[i]==0){
                ans[1]=i;
                break;
            }
        }
        return ans;
    }
}