class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            int u = edge[1];
            int v = edge[0];
            graph.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int order[] = new int[numCourses];
        int indx = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            order[indx++] = curr;
            for (int neig : graph.get(curr)) {
                indegree[neig]--;
                if (indegree[neig] == 0) {
                    q.offer(neig);
                }
            }
        }
        if (indx != numCourses)
            return new int[] {};
        return order;
    }
}