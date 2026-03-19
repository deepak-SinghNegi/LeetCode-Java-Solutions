class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] preX = new int[rows + 1][columns + 1];

        int[][] preY = new int[rows + 1][columns + 1];

        int xCount = 0;
        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= columns; j++) {
                preX[i][j] = grid[i - 1][j - 1] == 'X' ? preX[i - 1][j] + preX[i][j - 1] - preX[i - 1][j - 1] + 1
                        : preX[i - 1][j] + preX[i][j - 1] - preX[i - 1][j - 1];
                preY[i][j] = grid[i - 1][j - 1] == 'Y' ? preY[i - 1][j] + preY[i][j - 1] - preY[i - 1][j - 1] + 1
                        : preY[i - 1][j] + preY[i][j - 1] - preY[i - 1][j - 1];

            }

        }
        int count = 0;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if ((i == 1 && j == 1) || preX[i][j] == 0 || preY[i][j] == 0)
                    continue;
                if (preX[i][j] == preY[i][j])
                    count++;
            }
        }
        return count;
    }
}