class Solution {
    int [] freq = new int [10];
    public boolean isFascinating(int n) {
        if(n*2 >=1000 || n*3 >=1000) return false;
        return digitsCheck(n) && digitsCheck(n*2) && digitsCheck(n*3);
    }
    private boolean digitsCheck(int n){
        while(n != 0){
            int dig = n %10;
            if(dig == 0) return false;
            if(freq[dig] >0)
                return false;
            freq[dig]++;
            n/=10;
        }
        return true;
    }
}