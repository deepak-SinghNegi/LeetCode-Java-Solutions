class Solution {
    int[] parent;
    int[] rank;

    private void union(int a, int b) {
        int a_parent = find(a);
        int b_parent = find(b);
        if (a_parent == b_parent)
            return;
        if (rank[a_parent] > rank[b_parent]) {
            parent[b_parent] = a_parent;
        } else if (rank[b_parent] > rank[a_parent]) {
            parent[a_parent] = b_parent;
        } else {
            parent[a_parent] = b_parent;
            rank[b_parent]++;
        }
    }

    private int find(int x) {
        if (parent[x] == x)
            return x;
        return find(parent[x]);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (find(u) == find(v))
                return new int[] { u, v };
            union(u, v);
        }
        return new int[] { -1, -1 };
    }
}