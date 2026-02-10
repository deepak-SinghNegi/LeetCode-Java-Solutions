class Solution {
    public String simplifyPath(String path) {
        String [] splitedStr = path.split("/");
        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack<>();
        int sz = splitedStr.length;

        for (int i = 0; i <sz; i++) {
            String sAtI = splitedStr[i];

            if (sAtI.equals("") || sAtI.equals("."))
                continue;

            else if (sAtI.equals("..")  ) {

                if(!st.isEmpty())st.pop();

            } else {

                st.push(sAtI);
            }

        }
        sb = new StringBuilder();

        while (!st.isEmpty()) {

            sb.insert(0, "/" + st.pop());

        }
        if(sb.length()==0) return "/";
        return sb.toString();
    }
}