import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        int[][] arr = new int[rowIndex + 1][rowIndex + 1];

        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
        }

       
        for (int j = 0; j <= rowIndex; j++) {
            list.add(arr[rowIndex][j]);
        }

        return list;
    }
}
