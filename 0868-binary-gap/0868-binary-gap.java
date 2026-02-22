class Solution {
    public int binaryGap(int n) {
        int index1 =0;
        int index2 =0;
        while((n&1)!=1){
            n>>=1;
        }
        int maxGap = 0;
        while(n!=0){
            
            if((n&1)==1){
                maxGap = Math.max(index1-index2,maxGap);
                index2 = 0;
                index1 = 0;
            
            }
                
            index1++;
            n>>=1;


        }
        return maxGap;
    }
}