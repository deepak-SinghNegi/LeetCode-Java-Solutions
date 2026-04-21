class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int [] prifix = new int [n];
        prifix[0] = nums[0];
        for(int i = 1; i < n; i++){
            prifix[i] = nums[i] + prifix[i - 1];
        }
        int sum = sum = -10001;
        int c = 0;
        int j = 0;
        int i = 0;
        while( i < n){
            
            if(sum == k){
                c++;
                
                
                sum = prifix[i++];
                
            }
             if(sum < k){
                sum = prifix[i++];
            }
            
            while( j< i && sum > k) sum = sum - prifix[j++];

           
            
              
            

        }
        return c + 1;
    }
}