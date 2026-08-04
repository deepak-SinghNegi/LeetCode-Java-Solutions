class Solution {
    private boolean isVowel(char ch) {

        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    public String reverseVowels(String s) {

        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {

            while (i < j && !isVowel(sb.charAt(i))) {
                i++;
            }

            while (i < j && !isVowel(sb.charAt(j))) {
                j--;
            }

            char t = sb.charAt(i);
            sb.setCharAt(i++, sb.charAt(j));
            sb.setCharAt(j--, t);

        }
        return sb.toString();
    }
}