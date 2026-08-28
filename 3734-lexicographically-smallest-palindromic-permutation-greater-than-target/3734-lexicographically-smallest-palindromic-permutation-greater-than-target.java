class Solution {
    int freq[];
    int n;
    String midChar = "";

    public String lexPalindromicPermutation(String s, String target) {
        n = s.length();
        freq = new int[26];

        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        boolean oddChar = false;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                if (oddChar)
                    return "";

                midChar = String.valueOf((char) ('a' + i));
                oddChar = true;
            }
        }
        for (int i = 0; i < 26; i++) {
            freq[i] /= 2;
        }
        StringBuilder sb = new StringBuilder();
        if (helper(target, sb, false, 0)) {
            return sb.toString() + midChar + sb.reverse().toString();
        }
        return "";

    }

    private boolean helper(String t, StringBuilder sb, boolean greater, int i) {
        if (i == n / 2) {
            
            if (greater)
                return true;
                StringBuilder sb1 = new StringBuilder();
                sb1.append(sb);
            String candidate = sb.toString()+midChar+sb1.reverse().toString();
            return candidate.compareTo(t) > 0;
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (freq[ch - 'a'] == 0)
                continue;
            if (!greater && ch < t.charAt(i))
                continue;

            boolean isGreater = greater || ch > t.charAt(i) ;
            sb.append(ch);
            freq[ch - 'a']--;
            if (helper(t, sb, isGreater, i + 1))
                return true;
            sb.deleteCharAt(sb.length() - 1);
            freq[ch - 'a']++;

        }
        return false;

    }
}