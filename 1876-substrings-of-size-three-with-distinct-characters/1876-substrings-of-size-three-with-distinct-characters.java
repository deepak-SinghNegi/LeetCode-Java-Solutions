class Solution {
    public int countGoodSubstrings(String s) {
        int freq[] = new int[26];
        int size = 3;
        int count = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char chr = s.charAt(r);
            if (freq[chr - 'a'] == 0)
                size--;
            freq[chr - 'a']++;
            if (size == 0) {
                count++;
            }
            if (r - l + 1 >= 3) {
                char chl = s.charAt(l++);
                if (freq[chl - 'a']-- == 1)
                    size++;
            }
        }
        return count;
    }
}