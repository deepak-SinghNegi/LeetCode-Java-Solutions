class Solution {
    public boolean isTrionic(int[] nums) {
        boolean flage = true;
        int p =0;
        int q = 0;
        int r = 0;
        
        
        if(nums.length < 4)return false;
        if(nums[0]>nums[1])return false;
        if(nums[nums.length-2]>nums[nums.length-1])return false;
        
        for(int i =0; i<nums.length-1 ;i++){
            if(nums[i]==nums[i+1])return false;
            
            if(nums[i]<nums[i+1] ){
                if(flage){
                    p++;
                    flage = true;
                }
                
                else{
                    q=0;
                    r++;
                }
                
                
                
                
            }
            else{
               if(r>0)return false;
               else{
                q++;
               p=0;
                flage = false;
               }
                
               
            }

        }
        
      if(p==0&&q==0&&r>0){
        return true;
      }
      return false;
    }
}