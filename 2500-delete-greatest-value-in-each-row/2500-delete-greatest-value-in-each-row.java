class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        for(int [] arr : grid){
            Arrays.sort(arr);
        }
        int ans = 0;
        for(int i = 0; i< m;i++){
            int max = 0;
            for(int j = 0; j<n;j++){
                max = Math.max(max , grid[j][i]);
            }
            ans +=max;
        }
        return ans;
    }
}