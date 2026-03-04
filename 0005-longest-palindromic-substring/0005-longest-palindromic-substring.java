class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for(int i = 0;i<s.length();i++){
            for(int j = i+1 ; j<=s.length();j++){
                String ss = s.substring(i , j);
             int x =0;
             int y =ss.length()-1;
             while(x<y && ss.charAt(x) == ss.charAt(y)){
                x++;
                y--;
             }
             if(x>=y && ss.length()>ans.length()){
                ans =ss;
             }
            }
        }
        return ans;
    }
}