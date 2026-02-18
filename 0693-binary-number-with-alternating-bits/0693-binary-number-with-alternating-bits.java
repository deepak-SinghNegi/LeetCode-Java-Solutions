class Solution {
    public boolean hasAlternatingBits(int n) {
        int bit =n%2;
        n=n/2;
        int i =31;
        while(i>=0&&n>0){
            if(n%2==bit)return false;
            bit=n%2;
            i--;
            n/=2;
        }
        return true; 
    }
}