class State {
    int row;
    int col;
    int enr;
    int lit;

    public State(int row, int col, int enr, int lit) {
        this.row = row;
        this.col = col;
        this.enr = enr;
        this.lit = lit;
    }
}

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int n = classroom.length;
        int m = classroom[0].length();

        int rd[] = {1, -1, 0, 0};
        int cd[] = {0, 0, 1, -1};

        Queue<State> q = new LinkedList<>();

        int[][] litterBit = new int[n][m];

        for (int i = 0; i < n; i++)
            Arrays.fill(litterBit[i], -1);

        int litter = 0;
        int sr = 0;
        int sc = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < classroom[i].length(); j++) {

                if (classroom[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                }

                if (classroom[i].charAt(j) == 'L') {
                    litterBit[i][j] = litter;
                    litter++;
                }
            }
        }

        int totalMask = (1 << litter) - 1;

        boolean visited[][][][] =
                new boolean[n][m][energy + 1][1 << litter];

        q.add(new State(sr, sc, energy, 0));
        visited[sr][sc][energy][0] = true;

        int cost = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                State curr = q.poll();

                if (curr.lit == totalMask)
                    return cost;

                if (curr.enr == 0)
                    continue;

                for (int j = 0; j < 4; j++) {

                    int nr = curr.row + rd[j];
                    int nc = curr.col + cd[j];

                    if (nr < 0 || nr >= n ||
                        nc < 0 || nc >= classroom[nr].length())
                        continue;

                    if (classroom[nr].charAt(nc) == 'X')
                        continue;

                    int newEnr = curr.enr - 1;
                    int newLit = curr.lit;

                    // Collect litter
                    if (litterBit[nr][nc] != -1) {
                        newLit = newLit | (1 << litterBit[nr][nc]);
                    }

                    // Recharge
                    if (classroom[nr].charAt(nc) == 'R') {
                        newEnr = energy;
                    }

                    if (!visited[nr][nc][newEnr][newLit]) {

                        visited[nr][nc][newEnr][newLit] = true;

                        q.add(new State(
                                nr,
                                nc,
                                newEnr,
                                newLit
                        ));
                    }
                }
            }

            cost++;
        }

        return -1;
    }
}