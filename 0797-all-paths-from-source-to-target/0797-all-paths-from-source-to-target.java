class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        dfs(paths , graph , new ArrayList<>() , 0);
        return paths;
    }

    private void dfs(List<List<Integer>> paths , int [][]graph , List<Integer>list,int idx){
        list.add(idx);
        if(idx == graph.length-1){
            paths.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i< graph[idx].length;i++ ){
                int neighbor = graph[idx][i];
                dfs(paths , graph , list , neighbor );
                list.remove(list.size() -1);
        }
    }
}