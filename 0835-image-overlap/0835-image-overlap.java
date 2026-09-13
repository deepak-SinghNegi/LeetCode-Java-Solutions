class Solution {

    public int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length;
        int maxOverlap = 0;

        // Try every possible vertical translation
        for (int dr = -(n - 1); dr <= n - 1; dr++) {

            // Try every possible horizontal translation
            for (int dc = -(n - 1); dc <= n - 1; dc++) {

                int overlap = 0;

                // Check every cell of img1
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {

                        if (img1[r][c] == 0)
                            continue;

                        int nr = r + dr;
                        int nc = c + dc;

                        // Check whether translated position is inside img2
                        if (nr >= 0 && nr < n &&
                            nc >= 0 && nc < n) {

                            if (img2[nr][nc] == 1) {
                                overlap++;
                            }
                        }
                    }
                }

                maxOverlap = Math.max(maxOverlap, overlap);
            }
        }

        return maxOverlap;
    }
}