class Solution {
    int degreeSum = 0;
    int nodes = 0;

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());

        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);

        }
        boolean visited[] = new boolean[n];
        int c = 0;
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                dfs(graph, visited, i);
                if (nodes * (nodes - 1) == degreeSum)
                    c++;
            }

            degreeSum = 0;
            nodes = 0;
        }
        return c;
    }

    private void dfs(List<List<Integer>> graph, boolean[] visited, int u) {
        visited[u] = true;
        nodes++;
        degreeSum += graph.get(u).size();
        for (int neighbor : graph.get(u)) {
            if (!visited[neighbor]) {

                dfs(graph, visited, neighbor);
            }

        }

    }
}