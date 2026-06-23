class Solution {
    public int countPaths(int n, int[][] roads) {

        int MOD = 1_000_000_007;

        List<List<int[]>> graph = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        
        for (int i = 0; i < roads.length; i++) {

            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];

            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[1] - b[1]);

        long[] costs = new long[n];
        int[] ways = new int[n];

        Arrays.fill(costs, Long.MAX_VALUE);

        costs[0] = 0;
        ways[0] = 1;

        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {

            int[] curr = pq.remove();

            int currNode = curr[0];
            long currTime = curr[1];

           
            if (currTime > costs[currNode]) continue;

            for (int[] edge : graph.get(currNode)) {

                int nextNode = edge[0];
                long newTime = currTime + edge[1];

                if (newTime < costs[nextNode]) {

                    costs[nextNode] = newTime;
                    ways[nextNode] = ways[currNode];

                    pq.add(new int[]{nextNode, (int)newTime});

                } else if (newTime == costs[nextNode]) {

                    ways[nextNode] = (ways[nextNode] + ways[currNode]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}