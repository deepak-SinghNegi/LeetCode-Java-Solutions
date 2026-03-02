class Solution {
    public int minSwaps(int[][] grid) {
        int count = 0;
        int[] arr = new int[grid.length];
        int index = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    index = j;
                    break;
                }
            }
            arr[i] = index;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i;
            while (j < arr.length && arr[j] > i)
                j++;

            if (j == arr.length)
                return -1;

            while (i != j) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
                count++;
            }
        }

        return count;
    }
}