class Solution {
    public String smallestPalindrome(String s) {
        int freq[] = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        String mid = "";
        if (s.length() % 2 == 1) {
            mid += s.charAt(s.length() / 2);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            int c = freq[ch - 'a'] / 2;
            while (c > 0) {
                c--;
                sb.append(ch);
                
            }
        }
        return sb.toString() +mid+sb.reverse().toString();
    }
}