class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currProfit = 0;
        int left = 0;
        
        for(int right = 1;right<prices.length;right++){
            if(prices[left]>prices[left+1]&&left<prices.length-1){
                left = left+1;
            }
            boolean flage =true;
           while(prices[right]>prices[right-1]&&right<prices.length-1){
                if(prices[right+1]>prices[right])right++;
                else{
                    flage =false;
                    currProfit += prices[right]-prices[left];
                    right++;
                }
                
                

            }
            if(flage==true)currProfit += prices[right]-prices[left];
            maxProfit = Math.max(maxProfit,currProfit);
            left = right;
            

        }
        return maxProfit;
    }
}