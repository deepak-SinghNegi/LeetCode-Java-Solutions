class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix[0].length - 1;
        int l = 0;
        while (l < matrix.length && r >= 0) {
            if (matrix[l][r] == target)
                return true;
            else if (matrix[l][r] < target)
                l++;
            else
                r--;
        }
        return false;
    }
}