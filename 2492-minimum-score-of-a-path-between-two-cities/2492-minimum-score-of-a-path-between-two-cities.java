class Solution {

    int min = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        boolean[] visited = new boolean[n + 1];

        dfs(1, graph, visited);

        return min;
    }

    private void dfs(int u, List<List<int[]>> graph, boolean[] visited) {

        visited[u] = true;

        for (int[] edge : graph.get(u)) {

           
            min = Math.min(min, edge[1]);

            if (!visited[edge[0]]) {
                dfs(edge[0], graph, visited);
            }
        }
    }
}