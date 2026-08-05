class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invo) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < invo.length; i++) {
            int u = invo[i][0];
            int v = invo[i][1];

            graph.get(u).add(v);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(k);
        visited[k] = true;
        while (!q.isEmpty()) {

            int size = q.size();
            int curr = q.poll();
            set.add(curr);
            
            for (int neig : graph.get(curr)) {
                if (!visited[neig]) {
                    visited[neig] = true;
                    q.offer(neig);
                }

            }

            
        }
        boolean flag = false;
        for (int i = 0; i < invo.length; i++) {
            int u = invo[i][0];
            int v = invo[i][1];
            if (!set.contains(u) && set.contains(v)) {
                flag = true;
                break;
            }

        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (flag)
                res.add(i);
            else if (!set.contains(i))
                res.add(i);
        }
        return res;
    }

}