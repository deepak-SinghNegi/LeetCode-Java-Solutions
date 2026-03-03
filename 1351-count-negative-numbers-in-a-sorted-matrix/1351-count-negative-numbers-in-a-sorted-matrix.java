class Solution {
    public int countNegatives(int[][] grid) {
        int maxRow = grid.length;
        int row = 0;
        int col = grid[0].length - 1;
        int count = 0;
        while (row < grid.length && col >= 0) {
            if (grid[row][col] < 0) {

                count += maxRow - row;

                col--;
            } else {
                row++;
            }
        }
        return count;
    }
}