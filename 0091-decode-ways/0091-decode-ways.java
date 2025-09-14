class Solution {
   private int Y(String s , int i,int [] Dp){
    if(i == s.length()) return 1;
    if(s.charAt(i)=='0') return 0;
    if(Dp[i]!=-1) return Dp[i];
    int num =0;
    num += Y(s, i+1,Dp);
    int valid = 0;
    if(i+2<=s.length()) valid = Integer.parseInt(s.substring(i, i+2));
    if(valid<=26&& valid>=10){
        num+=Y(s, i+2,Dp);
    }

    return Dp[i] = num;
        
        }

        
 public int numDecodings(String s) {
        // int length = s.length()-1;
        int [] Dp = new int[s.length()+1];
        Arrays.fill(Dp,-1);

       return Y(s, 0,Dp); 
    }
    }