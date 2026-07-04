class Solution {
    public int minScore(int n, int[][] roads) {
        int r = roads.length;
        int c = roads[0].length;
        List<List<int[]>> graph  = new ArrayList<>();
        for(int i = 0; i< n+1; i++){
            graph.add(new ArrayList<>());
        } 
        for(int i = 0; i < r; i++ ){
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];
            graph.get(u).add(new int []{v,w});
            graph.get(v).add(new int []{u,w});
        }
        // System.out.println(graph);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        boolean [] visited = new boolean [n+1];
        int indx = 1;
        pq.add(new int []{1,0});
        int min = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int [] curr = pq.remove();
            int u = curr[0];
            int w = curr[1];
            if(w !=0)min = Math.min(curr[1] , min);
            if(visited[u]) continue;
            visited[u] = true;
            
            for(int [] arr :  graph.get(u)){ 
                if(!visited[arr[0]])pq.add(new int []{arr[0],arr[1]});
            }

        }
        return min;
    }
}