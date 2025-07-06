class Solution {
    public boolean isValid(int[] piles, int h,int k){
        int spendHr = 0;
        int i=0;
        
        while(i<piles.length){
            if(piles[i]/k==0){
                spendHr++;
                i++;
            }
            else{
                if(piles[i]%k==0){
                    spendHr += (piles[i]/k);
                    i++;
                }
                else{
                    spendHr += (piles[i]/k)+1;
                    i++;
                }
            }
        }
        if(spendHr<=h)return true;
        return false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = Integer.MIN_VALUE;
        for(int speed : piles){
            // minSpeed = Math.min(minSpeed,speed);
            maxSpeed = Math.max(maxSpeed,speed);
        }
        int ans = -1;
        while(minSpeed<=maxSpeed){
            int midSpeed = minSpeed + (maxSpeed-minSpeed)/2;
            if(isValid( piles , h , midSpeed)){
                ans = midSpeed;
                maxSpeed = midSpeed-1;
            }
            else{
                minSpeed = midSpeed+1;
            }
        }
        return ans;
    }
}