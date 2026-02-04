class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int fCol = 0;
        int lCol = matrix[0].length - 1;
        int fRow = 0;
        int lRow = matrix.length - 1;
        int mainRow = -1;
        while (fRow <= lRow) {
            int mid = fRow + (lRow - fRow) / 2;
            if (matrix[mid][fCol] <= target && target <= matrix[mid][lCol]) {
                mainRow = mid;
                break;
            } else if (target > matrix[mid][lCol]) {
                fRow = mid + 1;
            } else {
                lRow = mid - 1;
            }

        }
        if (mainRow == -1)
            return false;

        while (fCol <= lCol) {
            int mid = fCol + (lCol - fCol) / 2;
            if (matrix[mainRow][mid] == target)
                return true;
            else if (target > matrix[mainRow][mid]) {
                fCol = mid + 1;
            } else {
                lCol = mid - 1;
            }
        }
        return false;
    }
}
