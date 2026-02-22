class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int time = 0;
        int i =0;
        while(tickets[k]!=0){
            if(tickets[i]!=0){
                
                tickets[i]--;
                time++;
            }
                i++;
                i = i%n;
        }
        return time ;
    }
}