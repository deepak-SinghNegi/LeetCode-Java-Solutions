class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {


        List<List<int[]>> graph = new ArrayList<>(n+1);


        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }


        for(int i=0;i<times.length;i++){

            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];


            graph.get(u).add(new int[]{v,wt});

        }

        int [] cost = new int[n+1];
        // boolean [] visited = new boolean[n+1];
        Arrays.fill(cost , Integer.MAX_VALUE);
        cost[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{k , cost[k]});
        while(!pq.isEmpty()){
            int curr[] = pq.remove();
            int currV = curr[0];
            int currWt = curr[1];
            for(int [] edge : graph.get(currV)){
                int nextV = edge[0];
                int nextWt = edge[1];
                if(currWt + nextWt < cost[nextV]) {
                    cost[nextV] =  currWt + nextWt;
                    pq.add(new int[]{nextV , cost[nextV]});
                }
            }
            
        }
        int ans = 0;
        for(int i = 1; i<cost.length;i++){
            ans = Math.max(ans , cost[i]);
        }
    return ans == 0 || ans == Integer.MAX_VALUE ? -1 : ans;
    }
}