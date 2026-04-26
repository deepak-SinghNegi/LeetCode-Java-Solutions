class Solution {
    private boolean  isPallindrom(String s,int i,int j,boolean [][] Dp){
        if(i>=j) return true;
        if(Dp[i][j] ) return Dp[i][j];
        if(s.charAt(i)==s.charAt(j)) return Dp[i][j] = isPallindrom(s, i+1, j-1,Dp);
        else{
            return Dp[i][j]=false;
        }
        
    }
    public String longestPalindrome(String s) {
        boolean [][]Dp = new boolean[s.length()+1][s.length()+1];
       
        String longest = "";
        for(int i=0;i<s.length();i++){
            for(int j=s.length()-1;j>=0;j--){
                if(isPallindrom(s, i, j,Dp)){
                    if(j-i+1>longest.length())longest = s.substring(i, j+1);
                   
                }
                
            }
        }
        return longest;
    }
}