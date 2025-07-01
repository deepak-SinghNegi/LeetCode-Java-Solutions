class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int totalStfCus = 0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0){
                totalStfCus+=customers[i];
            }
        }
        int left = 0;
        int maxUnStfCus = 0;
        int UnStfCus = 0;
        for(int right = 0;right<customers.length;right++){
            
            if(grumpy[right]==1){
                UnStfCus+=customers[right];
                
            }
            
            while(right - left +1>minutes){
                if(grumpy[left]==1){
                    UnStfCus-=customers[left];
                    left++;
                }
                else left++;
                
            }
            maxUnStfCus = Math.max(maxUnStfCus,UnStfCus);
        }
            totalStfCus= totalStfCus+maxUnStfCus;
       return totalStfCus; 
    }
}