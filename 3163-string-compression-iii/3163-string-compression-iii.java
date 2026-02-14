class Solution {
    public String compressedString(String word) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            while (i < word.length() - 1 && count < 9 && ch == word.charAt(i + 1)) {
                count++;
                i++;
            }

            sb.append(Integer.toString(count));
            sb.append(ch);
            count = 1;

        }
        return sb.toString();
    }
}