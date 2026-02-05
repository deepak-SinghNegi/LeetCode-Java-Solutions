class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int [] ans = new int [code.length];
        int sum =0;
        if(k==0)
            return ans;
        else if(k>0){
            for(int i =1; i<=k; i++){
                sum+=code[i%n];
            }
            ans[0] = sum;

            for(int i=1;i<ans.length;i++){
                ans[i] = ans[i-1]-code[i]+code[(i+k)%n];
            }
        }
        else{
            k =-k;
            for(int i=1;i<=k;i++){
                sum+=code[(n-i)%n];
            }
            ans[0] = sum;

            for(int i=1;i<ans.length;i++){
                ans[i] = ans[i-1]+code[(i-1)]-code[(n-k+i-1)%n];
            }
        }
        return ans;

    }
}