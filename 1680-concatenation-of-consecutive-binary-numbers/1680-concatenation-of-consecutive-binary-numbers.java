class Solution {
    public int concatenatedBinary(int n) {
        long ans = 1;
        int x =1;
        for(int i = 2;i<=n;i++){
            if((i&(i-1))==0){
                x++;
            }
            ans<<=x;
            ans+=i;
                
            ans%=1000000007;
        }
        return(int)(ans);
    }
}