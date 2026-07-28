class Solution {
    public String smallestPalindrome(String s) {
        int freq[] = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        char mid = '1';
        if (s.length() % 2 == 1) {
            mid = s.charAt(s.length() / 2);
        }
        System.out.print(mid);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            int c = freq[ch - 'a'] / 2;
            while (c > 0) {
                c--;
                sb.append(ch);
                freq[ch - 'a']--;
            }

        }
        if (sb.isEmpty())
            return s;
        if (mid != '1') {
            sb.append(mid);
            freq[mid - 'a']--;
        }

        int n = sb.length();

        if (s.length() % 2 == 0) {
            for (int i = n - 1; i >= 0; i--) {
                char ch = sb.charAt(i);
                if (freq[ch - 'a'] > 0)
                    sb.append(ch);
            }

        } else {
            for (int i = n - 2; i >= 0; i--) {
                char ch = sb.charAt(i);
                if (freq[ch - 'a'] > 0)
                    sb.append(ch);
            }

        }
        return sb.toString();
    }
}