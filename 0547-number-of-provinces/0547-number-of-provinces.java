class Solution {
    int n = 0;
    boolean visited[];

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                q.add(i);
                visited[i] = true;
                while (!q.isEmpty()) {
                    int s = q.poll();
                    for (int j = 0; j < n; j++) {
                        if (isConnected[s][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            q.add(j);
                        }

                    }
                }
                provinces++;

            }
        }
        return provinces;
    }

}