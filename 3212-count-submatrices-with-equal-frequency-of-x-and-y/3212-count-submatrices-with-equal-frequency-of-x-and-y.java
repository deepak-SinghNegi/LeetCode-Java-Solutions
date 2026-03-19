class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] preX = new int[rows][columns];
        preX[0][0] = grid[0][0] == 'X' ? 1 : 0;
        int[][] preY = new int[rows][columns];
        preY[0][0] = grid[0][0] == 'Y' ? 1 : 0;
        int xCount = 0;
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (i == 0) {
                    preX[i][j] = grid[i][j] == 'X' ? preX[i][j - 1] + 1 : preX[i][j - 1];
                    preY[i][j] = grid[i][j] == 'Y' ? preY[i][j - 1] + 1 : preY[i][j - 1];
                } else {
                    if (j == 0) {
                        preX[i][j] = grid[i][j] == 'X' ? preX[i - 1][j] + 1 : preX[i - 1][j];
                        preY[i][j] = grid[i][j] == 'Y' ? preY[i - 1][j] + 1 : preY[i - 1][j];
                    } else {
                        preX[i][j] = grid[i][j] == 'X' ? preX[i - 1][j] + preX[i][j - 1] - preX[i - 1][j - 1] + 1
                                : preX[i - 1][j] + preX[i][j - 1] - preX[i - 1][j - 1];
                        preY[i][j] = grid[i][j] == 'Y' ? preY[i - 1][j] + preY[i][j - 1] - preY[i - 1][j - 1] + 1
                                : preY[i - 1][j] + preY[i][j - 1] - preY[i - 1][j - 1];
                    }
                }

            }

        }
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if ((i == 0 && j == 0) || preX[i][j] == 0 || preY[i][j] == 0)
                    continue;
                if (preX[i][j] == preY[i][j])
                    count++;
            }
        }
        return count;
    }
}