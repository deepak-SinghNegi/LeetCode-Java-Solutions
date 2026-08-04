class Solution {
    private boolean isVowel(char ch) {
        char x = Character.toLowerCase(ch);
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }

    public String reverseVowels(String s) {

        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            char chl = s.charAt(i);
            char chr = s.charAt(j);
            if (isVowel(chl) && isVowel(chr)) {
                char t = sb.charAt(i);
                sb.setCharAt(i++, sb.charAt(j));
                sb.setCharAt(j--, t);
            } else if (isVowel(chl)) {
                j--;
            } else if (isVowel(chr)) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return sb.toString();
    }
}