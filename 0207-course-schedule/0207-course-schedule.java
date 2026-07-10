class Solution {
    public boolean canFinish(int n, int[][] prereq) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0; i<n; i++ ){
            graph.add(new ArrayList<>());

        }
        for(int i = 0; i< prereq.length;i++){
            int u = prereq[i][0];
            int v = prereq[i][1];
            graph.get(v).add(u);
        }

        boolean visited [] =  new boolean[n];
        boolean path [] =  new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(dfs(graph , visited, path , i))return false;
            }
        }
        return true;
    }
    private boolean dfs(List<List<Integer>> graph , boolean [] visited ,boolean [] path, int s){
        visited[s] = true;
        path[s] = true;
        for(int neighbor : graph.get(s)){
            if(!visited[neighbor]){
                if(dfs(graph , visited, path, neighbor))
                    return true;
            }
            else if(path[neighbor])
                return true;
        }
        path[s] = false;
        return false;
    }
}