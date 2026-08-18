class Solution {
    int n = 0;
    boolean visited[];

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        visited = new boolean [n];
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, i);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected, int s) {
        visited[s] = true;
        for (int i = 0; i < isConnected[s].length; i++) {
            if (isConnected[s][i] == 1 && !visited[i]) {
                dfs(isConnected, i);
            }
        }
    }
}