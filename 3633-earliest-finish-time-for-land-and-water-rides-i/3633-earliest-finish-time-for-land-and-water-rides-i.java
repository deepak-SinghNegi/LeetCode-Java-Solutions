class Solution {
    public int earliestFinishTime(int[] lst, int[] ld, int[] wst, int[] wd) {
        int n = lst.length;
        int m = wst.length;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int le = lst[i] + ld[i];
            for(int j = 0; j < m; j++){
                int we = wst[j] + wd[j];
                int f1 = Math.max(le , wst[j]) + wd[j];
                int f2 = Math.max(we , lst[i]) + ld[i];
                ans = Math.min(ans , Math.min(f1 , f2));
            }
        }
        return ans;
    }
}