class Solution {
    public boolean checkOnesSegment(String s) {
       
        int x =0;
        while(x<s.length()&&s.charAt(x) == '1' ){
            x++;
           
        }
        while(x<s.length() && s.charAt(x)=='0'){
            x++;
        }
        if(x>=s.length() ) return true;

        return false;
    }
}