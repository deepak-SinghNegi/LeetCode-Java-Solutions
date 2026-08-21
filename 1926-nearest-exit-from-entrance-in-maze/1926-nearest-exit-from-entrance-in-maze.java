class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        int rd[] = { 0, 0, -1, 1 };
        int cd[] = { -1, 1, 0, 0 };
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { entrance[0], entrance[1] });
        maze[entrance[0]][entrance[1]] = '+';
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int curr[] = q.poll();
                for (int i = 0; i < 4; i++) {
                    int r = curr[0] + rd[i];
                    int c = curr[1] + cd[i];
                    if (r >= 0 && r < n && c >= 0 && c < m) {
                        if (maze[r][c] == '.') {
                            if(r == 0 || r == n-1 || c ==0 || c == m-1){
                                return count+1;
                            }
                            q.add(new int[] { r, c });
                            maze[r][c] = '+';
                        }
                    }

                }
            }
            count++;
        }
        return -1;
    }
}