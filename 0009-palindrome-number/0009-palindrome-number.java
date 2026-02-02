class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        int temp = x;
        int revX = 0;
        while(temp>0){
            revX = revX*10 + temp%10;
            temp/=10;
        }
        if(revX==x) return true;
        return false;
    }
}