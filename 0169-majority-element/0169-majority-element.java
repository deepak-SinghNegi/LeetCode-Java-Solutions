class Solution {
    public int majorityElement(int[] nums) {
      
       int ans = 0;
       int c = 0;
       for(int num : nums){
        if(c == 0){
            ans = num;
        }
        if(ans == num)c++;
        else c--;
       }
       return ans;
    }
}