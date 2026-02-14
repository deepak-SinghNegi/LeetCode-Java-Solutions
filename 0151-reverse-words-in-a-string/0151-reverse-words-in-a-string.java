class Solution {
    public String reverseWords(String s) {
        Stack<String> rev = new Stack<>();
        String [] word = s.split(" ");
        for(String x : word){
            if(!x.isEmpty()){
                rev.push(x);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!rev.isEmpty()){
            sb.append(rev.pop());
            if(!rev.isEmpty())sb.append(" ");
        }
        return sb.toString();
    }
}