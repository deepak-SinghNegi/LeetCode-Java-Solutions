class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < word.length() && word.charAt(i) != ch) {
            stack.push(word.charAt(i));
            i++;
        }
        if (i < word.length() && word.charAt(i) == ch)
            stack.push(ch);
        
        if (i >= word.length())
            return word;
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.append(word.substring(i+1, word.length()));
        return sb.toString();

    }
}