class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
      
        Arrays.sort(nums);
        
        int currC = 1;
        int com = nums[0];
        for(int i = 1; i<n;i++){
            if(nums[i] == com) currC++;
           
            else {
                
                currC = 1;
                com = nums[i];
            }
            if(currC >= (n+1)/2) return com;
        }
        return currC >= (n+1)/2 ? com : -1;
    }
}