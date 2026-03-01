class Solution {
    public int minPartitions(String n) {
        
        int max = 0;
        int s = 0;
        int e = n.length()-1;
        while(e>=s){
            int val = Math.max(n.charAt(s)-'0' , n.charAt(e)-'0');
            max = Math.max(val , max);
            s++;
            e--;
        }
        return max;
    }
}