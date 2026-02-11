class Solution {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int maxSize = 0;
        int[] collMax = new int[grid[0].length];
        int[] rowMax = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {
                collMax[i] = Math.max(grid[i][j], collMax[i]);
            }

        }

        for (int j = 0; j < grid.length; j++) {

            for (int i = 0; i < grid[0].length; i++) {
                rowMax[i] = Math.max(grid[j][i], rowMax[i]);
            }

        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < Math.min(collMax[i], rowMax[j])) {
                    maxSize += Math.min(collMax[i], rowMax[j]) - grid[i][j];

                }
            }
        }

        return maxSize;

    }
}