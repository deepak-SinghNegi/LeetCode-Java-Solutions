class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        int count = 0;
        for(int i = 0; i< grid.length;i++){
            for(int j = 0; j<grid[0].length;j++){
                    if(grid[i][j] == 1) count++;
                    else if(grid[i][j] == 2){
                        q.add(new int[] {i , j});
                    }
            }
        }
        int [] dR = {-1 , +1 , 0 , 0};
        int [] dC = {0 , 0 , -1 , +1};
       if(count ==0 ) return 0;
       if(q.isEmpty()) return -1;
        while(!q.isEmpty()){
           int size = q.size();
           boolean isRot = false;
           for(int j = 0; j<size;j++){
                int [] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int i = 0; i< 4;i++){
                    int newRow = r+dR[i];
                    int newCol = c+dC[i];
                    if(newRow >=0 && newRow < grid.length && newCol >=0 && newCol<grid[0].length ){
                        if(grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        q.add(new int[]{newRow , newCol});
                        isRot = true;
                        count--;
                        }
                    }
                }
                
            
            }
            if(isRot)time++;


            
            
        } 
        return count == 0 ?  time : -1 ;
    }

}