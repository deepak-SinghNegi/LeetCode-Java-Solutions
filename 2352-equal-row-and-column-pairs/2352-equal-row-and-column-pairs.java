class Solution {
    public int equalPairs(int[][] grid) {
        Map<Integer, int[]> map = new HashMap<>();
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int[] arr = new int[n];
            int k = 0;
            for (int j = 0; j < n; j++) {
                arr[k++] = grid[j][i];
            }
            map.put(i, arr);
        }
        int c = 0;
        for (int[] row : grid) {
            for (int[] arr : map.values()) {

                if (Arrays.equals(arr, row))
                    c++;
            }
        }
        return c;
    }
}