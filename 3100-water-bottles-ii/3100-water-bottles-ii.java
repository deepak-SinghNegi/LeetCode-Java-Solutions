class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int maxDrink = 0;
        int emptyBottles= 0;
        for(int i =0;i<numBottles;i++)
            emptyBottles++;
         
        numBottles = 0;
        maxDrink+=emptyBottles;
        while(emptyBottles>=numExchange || numBottles!=0){
            
               if(emptyBottles<numExchange){
                maxDrink +=numBottles;
                emptyBottles+=numBottles;
                numBottles = 0;
            }
            else{
                 emptyBottles-=numExchange;
                    numExchange++;
                    numBottles++;
            }  
                   
                
            
            
        }
        return maxDrink;
    }
    
}
