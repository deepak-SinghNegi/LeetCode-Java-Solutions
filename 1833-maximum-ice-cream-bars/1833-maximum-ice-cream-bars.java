class Solution {
       
    public int maxIceCream(int[] costs, int coins) {
       Arrays.sort(costs);
       int count = 0;
       for(int cost : costs){
        if(coins < cost)break;
        count++;
        coins -= cost;
       }
       return count;
    }
}