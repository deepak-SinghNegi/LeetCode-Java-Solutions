class Solution {
    public String reverseVowels(String s) {
        Stack<Character> st = new Stack<>();
        String str = "AEIOUaeiou";
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (str.indexOf(ch) != -1)
                st.push(ch);
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (str.indexOf(ch) != -1)
                sb.setCharAt(i, st.pop());
        }
        return sb.toString();
    }
}