class Solution {
    public boolean checkString(String s) {
        int i =0;
        if(s.charAt(0)=='a'){
            while(s.charAt(i)=='a')i++;
        }
        while(i<s.length()){
            if(s.charAt(i)=='a')return false;
            i++;
        }
        return true;
    }
}