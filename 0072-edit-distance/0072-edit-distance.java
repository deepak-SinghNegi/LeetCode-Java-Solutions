class Solution {
    public int operationCount(String word1,String word2,int i,int j,int [][] Dp){
        if(i==-1) return j+1;
        if(j==-1) return i+1;

        if(Dp[i][j]!=-1) return Dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)) { return Dp[i][j] = operationCount(word1, word2, i-1, j-1,Dp);}
        else{
            // repalce 
             int num1 = 1+ operationCount(word1, word2, i-1, j-1,Dp);
            // remove
             int num2 = 1+ operationCount(word1, word2, i-1, j,Dp);
            // insert
             int num3 = 1+ operationCount(word1, word2, i, j-1,Dp);
             int min1 = Math.min(num2, num3);
             int min2 = Math.min(min1, num1);
             return Dp[i][j] = min2;
             

        }
        
        
    }

    public int minDistance(String word1, String word2) {
        int i = word1.length();
        int j = word2.length();
        int [][] Dp = new int[i+1][j+1];
        for(int [] row : Dp){
            Arrays.fill(row,-1);
        }
        return operationCount(word1, word2, i-1, j-1,Dp);
    }
}