class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        for (char ch : s1.toCharArray()) {
            freq[ch - 'a']++;
        }
        int size = s1.length();
        int left = 0;
        for (int right = 0; right < s2.length(); right++) {

            char ch = s2.charAt(right);
            if (freq[ch - 'a'] > 0)
                size--;
            freq[ch - 'a']--;
            if (size == 0)
                return true;
            if (right - left + 1 == s1.length()) {
                char chl = s2.charAt(left);
                if (freq[s2.charAt(left) - 'a'] >= 0)
                    size++;
                freq[s2.charAt(left++) - 'a']++;
            }

        }
        return false;
    }
}