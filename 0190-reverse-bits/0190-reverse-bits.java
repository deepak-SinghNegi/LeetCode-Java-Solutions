class Solution {
    public int reverseBits(int n) {
        int [] bits = new int [32];
        int index = 31;
        while(n>0){
            bits[index] = n%2;
            index--;
            n=n/2;
        }
        
       int val =0;
        for(int i=0;i<32;i++){
            if(bits[i]==1){
                val +=Math.pow(2,i); 
            }
        }
        return val;
    }
}