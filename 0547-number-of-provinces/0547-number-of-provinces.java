class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        int c = 0;
        for(int i= 0;i<n;i++){
            if(!visited[i]){
                dfs(isConnected , visited , i);
                c++;
            }
        }
        return c;
    }
    private void dfs(int[][] isConnected ,boolean[] visited , int s){
       visited[s] = true;
       for(int i = 0;i<isConnected[0].length;i++){
            if(!visited[i] && isConnected[s][i] == 1){
                visited[i] = true;
                dfs(isConnected , visited , i);
            }
       }
        
    }
}