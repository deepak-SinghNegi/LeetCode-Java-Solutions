class Solution {
    public boolean check(int[] nums) {
        int n = nums.length-1;
      
       int ptr = 0;
       for(int i=1;i<=n;i++){
        if(nums[i]<nums[i-1]){
            
            ptr ++;
        }
        if(ptr>1 )return false;
       }
        if(ptr==1) {
            if(nums[0]<nums[n]) return false;
            else return true;
        }
        
        return true;
       
    }
}