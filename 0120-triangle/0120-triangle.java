class Solution {
   private int findMin(List<List<Integer>> triangle , int i,int j,int[][]Dp){
        if(i==triangle.size()-1)return triangle.get(i).get(j);
        if(Dp[i][j]!=-1) return Dp[i][j];
        int leftVal = findMin(triangle, i+1, j,Dp);
        int rightVal = findMin(triangle, i+1, j+1,Dp);
        return Dp [i][j] = triangle.get(i).get(j)+ Math.min(leftVal, rightVal);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][] Dp = new int[n][];
        for (int i = 0; i < n; i++) {
            Dp[i] = new int[triangle.get(i).size()];
            Arrays.fill(Dp[i], -1);
        }
        return findMin(triangle, 0, 0,Dp);
    }
}