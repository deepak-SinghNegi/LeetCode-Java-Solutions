class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int costs[][] = new int [n][m];
        for(int [] arr : costs){
            Arrays.fill(arr , Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> a[2] - b[2]);
        costs[0][0] = 0;
        pq.add(new int[]{ 0 , 0 , 0 });
        int [] row = {-1 , 1 , 0 , 0};
        int [] col = {0 , 0 , -1 , 1};
        
       while(!pq.isEmpty()){
          int [] curr = pq.remove();
          int h = curr[2];
          for(int i=0;i<4;i++){
            int r = curr[0] + row[i];
            int c = curr[1] + col[i];
            if(r >= 0 && r < n && c >= 0 && c < m){
                int diff = Math.abs(heights[curr[0]][curr[1]]- heights[r][c]);
                int effort = Math.max(h , diff);
                if(effort < costs[r][c]){
                    pq.add(new int[]{r , c , effort});
                    costs[r][c] = effort;
                }
            }
            
            
          }
       }
       
       return costs[n-1][m-1];
    }
}