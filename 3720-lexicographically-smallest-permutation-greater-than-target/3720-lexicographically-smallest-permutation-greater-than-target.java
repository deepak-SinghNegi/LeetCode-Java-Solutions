class Solution {
    int[] freq;
    int n;

    public String lexGreaterPermutation(String s, String target) {
        n = s.length();
        freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        if (helper(target, sb, 0, false)) {
            return sb.toString();
        }

        return "";
    }

    private boolean helper(String t, StringBuilder sb, int i, boolean greater) {

        if (i == n) {
            return greater;
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {

            if (freq[ch - 'a'] == 0) {
                continue;
            }

            if (!greater && ch < t.charAt(i)) {
                continue;
            }
            boolean newGreater = greater || ch > t.charAt(i);

            sb.append(ch);
            freq[ch - 'a']--;

            if (helper(t, sb, i + 1, newGreater)) {
                return true;
            }

            sb.deleteCharAt(sb.length() - 1);
            freq[ch - 'a']++;
        }

        return false;
    }
}