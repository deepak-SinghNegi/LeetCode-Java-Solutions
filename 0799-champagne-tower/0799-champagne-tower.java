class Solution {
           
    public double champagneTower(int poured, int row, int glass) {

        double [][] ans = new double [101][101];
        ans[0][0] = poured;
        for(int i=0;i<=row;i++){
            for(int j = 0;j<=i;j++){
                double extra = (ans[i][j]-1)/2.0;
                if(ans[i][j]>1){
                    ans[i+1][j] += extra;
                    ans[i+1][j+1] += extra;
                }

            }
        }
        return Math.min(1.0,ans[row][glass]);
        

    }
}