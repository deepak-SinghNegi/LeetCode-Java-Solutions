class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] preX = new int[rows + 1][columns + 1];

        int[][] preY = new int[rows + 1][columns + 1];

        int xCount = 0;
        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= columns; j++) {
                preX[i][j] = preX[i - 1][j] + preX[i][j - 1] - preX[i - 1][j - 1];
                preY[i][j] = preY[i - 1][j] + preY[i][j - 1] - preY[i - 1][j - 1];
                preX[i][j] = grid[i - 1][j - 1] == 'X' ? preX[i][j] + 1
                        : preX[i][j];
                preY[i][j] = grid[i - 1][j - 1] == 'Y' ? preY[i][j] + 1
                        : preY[i][j];

            }

        }
        int count = 0;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if (preX[i][j] == preY[i][j] && preX[i][j] > 0)
                    count++;
            }
        }
        return count;
    }
}