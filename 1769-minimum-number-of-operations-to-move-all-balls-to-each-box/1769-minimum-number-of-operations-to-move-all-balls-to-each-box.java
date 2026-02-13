class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int [] prifix = new int [n];
        int x = 1;
        int balls =0;
        while(x<n &&boxes.charAt(x-1)-'0'==0)x++;

        if(x>=n) return prifix;
        for(int i=1;i<n;i++){
           if(boxes.charAt(i-1)-'0'==1)balls++;
            
                
                prifix[i] =  prifix[i-1]+balls;
            
        }
        x = n-2;
        int [] sufix = new int [n];
        while(boxes.charAt(x+1)-'0'==0)x--;
        balls = 0;
        for(int i=x;i>=0;i--){
           if (boxes.charAt(i+1)-'0'==1)balls++;
            
                
                sufix[i] =  sufix[i+1]+balls;
            
        }
       
        for(int i=0;i<n;i++){
            prifix[i]+=sufix[i];
        }
        return prifix;
    }
}