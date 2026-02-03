class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int sRow = 0;
        int eRow = matrix.length - 1;
        int sCol = 0;
        int eCol = matrix[0].length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (eCol >= sCol && eRow >= sRow) {
            for (int i = sCol; i <= eCol; i++) {
                list.add(matrix[sRow][i]);
            }
            sRow++;
            
            for (int i = sRow; i <= eRow; i++) {

                list.add(matrix[i][eCol]);
            }
            eCol--;
            for (int i = eCol; i >= sCol; i--) {
                
                if(sRow>eRow)break;
                list.add(matrix[eRow][i]);
            }
            eRow--;
            for (int i = eRow; i >= sRow; i--) {
                if(sCol>eCol) break;
                list.add(matrix[i][sCol]);
            }
            sCol++;
        }
    return list;
    }
}