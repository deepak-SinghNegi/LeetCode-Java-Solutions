class Solution {
    private int  isPallindrom(String s,int i,int j,int [][] Dp){
        if(i>=j) return 1;
        if(Dp[i][j] != -1) return Dp[i][j];
        if(s.charAt(i)==s.charAt(j)) return Dp[i][j] = isPallindrom(s, i+1, j-1,Dp);
        else{
            return Dp[i][j]=0;
        }
        
    }
    public String longestPalindrome(String s) {
        int [][]Dp = new int[s.length()+1][s.length()+1];
        for(int[] arr : Dp){
            Arrays.fill(arr,-1);
        }
        String longest = "";
        for(int i=0;i<s.length();i++){
            for(int j=s.length()-1;j>=0;j--){
                if(isPallindrom(s, i, j,Dp)==1){
                    if(j-i+1>longest.length())longest = s.substring(i, j+1);
                   
                }
                
            }
        }
        return longest;
    }
}