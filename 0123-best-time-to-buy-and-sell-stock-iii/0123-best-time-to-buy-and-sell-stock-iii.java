class Solution {
    public int maxProfit(int[] prices) {
        int [] leftPass= new int[prices.length];
        int [] rightPass= new int[prices.length];
        // int currProfit = 0;
        int MaximumProfit = 0;
        int minPrice = prices[0];
        int maxPrice = prices[rightPass.length-1];
        for(int i=1;i<leftPass.length;i++){
            
            leftPass[i] = Math.max(leftPass[i-1],prices[i]-minPrice);
            // currProfit = Math.max(currProfit,leftPass[i]);
            minPrice = Math.min(minPrice,prices[i]);
        }
        // currProfit = 0;
        for(int i=rightPass.length-2;i>=0;i--){
            
            rightPass[i] = Math.max(rightPass[i+1],maxPrice-prices[i]);
            // currProfit = Math.max(currProfit,rightPass[i]);
            maxPrice = Math.max(maxPrice,prices[i]);
        }

        // for(int i=0;i<rightPass.length;i++){
            
        //     System.out.print(leftPass[i]+" ");
        // }
        // System.out.println();

        // for(int i=0;i<rightPass.length;i++){
            
        //     System.out.print(rightPass[i]+" ");
        // }
        // System.out.println();
        for(int i=0;i<rightPass.length;i++){
            
            MaximumProfit = Math.max(MaximumProfit,leftPass[i]+rightPass[i]);
        }
        
        
        
        
        return MaximumProfit;
    }
}