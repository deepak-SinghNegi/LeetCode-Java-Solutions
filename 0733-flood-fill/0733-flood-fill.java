class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if(originalColor == color)
            return image;
        dfs(image, originalColor, sr, sc , color);
        return image;
    }

    private void dfs(int[][] image, int originalColor, int r, int c , int color) {
        if (c < 0 || r < 0 || c >= image[0].length || r >= image.length)
            return;
        if (originalColor != image[r][c])
            return;
        image[r][c] = color;
        dfs(image, originalColor, r - 1, c ,color);
        dfs(image, originalColor, r + 1, c ,color);
        dfs(image, originalColor, r, c - 1 ,color);
        dfs(image, originalColor, r, c + 1 ,color);

    }
}