
class Solution {
    private int gcd(int a , int b){
       while(b!=0){
        int temp = a%b;
        a = b;
        b = temp;
       }
       return a;
    }
    public boolean canMeasureWater(int x, int y, int target) {
        if(target > x+y) return false;
        if(target == 0) return true;

        return target % gcd(x,y) == 0;

    }
}