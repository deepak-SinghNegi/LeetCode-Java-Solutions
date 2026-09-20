import java.util.*;

class Solution {

    private boolean isSafe(List<String> list, int r, int c, int n) {
        // Check same column
        for (int i = 0; i < r; i++) {
            if (list.get(i).charAt(c) == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (list.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
            if (list.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }

    private void helper(List<String> list, List<List<String>> board, int r, int n) {
        if (r == n) {
            board.add(new ArrayList<>(list));
            return;
        }

        for (int c = 0; c < n; c++) {
            if (isSafe(list, r, c, n)) {
                // Construct the row string directly for row r
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[c] = 'Q';
                
                // Add to path
                list.add(new String(row));

                // Recurse to next row
                helper(list, board, r + 1, n);

                // Backtrack path
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> board = new ArrayList<>();
        helper(new ArrayList<>(), board, 0, n);
        return board;
    }
}