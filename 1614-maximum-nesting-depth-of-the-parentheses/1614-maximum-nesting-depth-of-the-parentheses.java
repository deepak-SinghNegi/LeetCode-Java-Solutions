class Solution {
    public int maxDepth(String s) {
        
        int close =0;
        int open =0;
        int maxDepth = Integer.MIN_VALUE;
        for(int i= 0;i<s.length();i++){
            if(s.charAt(i)=='(')open++;
             if(s.charAt(i) ==')'){
            close++;
            }
            
                maxDepth = Math.max(open-close , maxDepth);
            
        }
        return maxDepth;
    }
}