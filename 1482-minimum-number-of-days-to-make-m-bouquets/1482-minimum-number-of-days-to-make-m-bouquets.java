class Solution {
    public boolean isValid(int[] bloomDay,int m,int k,int midDay){
        int bouquetsLeft = m;
        
        int available = 0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=midDay)available++;
            else{
                available=0;
            }
            if(available==k){
                bouquetsLeft--;
                available=0;
                if(bouquetsLeft==0)return true;
            }
            
        }
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;
        for(int i : bloomDay){
            minDay = Math.min(minDay,i);
            maxDay = Math.max(maxDay,i);
        }
       int ans=-1;
       while(minDay<=maxDay){
        int midDay = minDay+(maxDay-minDay)/2;
        if(isValid(bloomDay,m,k,midDay)){
            ans = midDay;
            maxDay = midDay-1;
        } else{
            minDay=midDay+1;
        }
       }
    return ans;
       
    }
}