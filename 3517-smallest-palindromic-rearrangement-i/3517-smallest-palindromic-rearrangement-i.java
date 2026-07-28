class Solution {
    public String smallestPalindrome(String s) {
        int freq[] = new int[26];
        int n = s.length();
        for (int i = 0; i<n/2;i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        String mid = "";
        if (n % 2 == 1) {
            mid += s.charAt(n/2);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            
            char ch = (char) ('a' + i);
            while(freq[ch - 'a']-- >0)
                sb.append(ch);
            
        }
        return sb.toString() +mid+sb.reverse().toString();
    }
}