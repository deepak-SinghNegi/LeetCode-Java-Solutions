class Solution {
    public boolean stoneGame(int[] piles) {
        
        int a = 0;
        int i = 0;
        int j = piles.length - 1;
        int sum = 0;
        for(int x = 0; x<= j; x++){
            sum += piles[x];
        }

        
        while(i < j){
           int indx = piles[i] > piles[j] ? i++ : j --; 
           a += piles[indx];
        }

        return a > sum/2 ;
        
    }
}