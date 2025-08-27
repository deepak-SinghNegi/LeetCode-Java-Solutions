class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes){
        int sutisfiedCust = 0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0){
                sutisfiedCust+=customers[i];
            customers[i]=0;
            }
        }
        int left=0;
        int sumOfUnstisfiedCust=0;
        int sum=0;
        for(int right=0;right<customers.length;right++){
            
            if(grumpy[right]==1){
                sum+=customers[right];
            }
            if(right-left+1==minutes){
                sumOfUnstisfiedCust = Math.max(sumOfUnstisfiedCust,sum);
                sum-=customers[left++];

            }
        }
        return sutisfiedCust+sumOfUnstisfiedCust;
    }
}