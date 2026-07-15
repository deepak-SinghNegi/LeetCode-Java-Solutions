class Solution {
    public String removeOuterParentheses(String s) {
        int countOpPar =0;
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(countOpPar >0)
                    sb.append(ch);
                countOpPar++;
            }
            else{
                countOpPar--;
                if(countOpPar >0)
                    sb.append(ch);
            }
        } 
        return sb.toString();
    }
}