class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() <= 1)
            return "";
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = ch1 >= 97 ? (char) (ch1 - 32) : (char) (ch1 + 32);

            if (!set.contains(ch2)) {
                String s1 = longestNiceSubstring(s.substring(i + 1) );
                String s2 = longestNiceSubstring(s.substring(0, i));
                return s2.length() < s1.length() ? s1 : s2;
            }
        }
        return s;
    }
}