class Solution {
    public int reverse(int x) {
        long rev = 0;
        int temp = Math.abs(x);
        while(temp>0){
           if(rev*10>=Integer.MAX_VALUE)return 0;
            rev *= 10;
             
            rev += temp%10;
            
            temp /= 10;
        }
        if(x<0) return (int)(-1*rev);
        return (int)rev;
    }
}