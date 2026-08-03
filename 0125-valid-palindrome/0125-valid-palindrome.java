class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch <= 'z' && ch >= 'a') || (ch <= 'Z' && ch >= 'A') || (ch >= '0' && ch <= '9')) {
                if (ch < 97) {
                    ch = (char) (ch + 32);
                }
                sb.append(ch);
            }
        }
        int l = 0;
        int r = sb.length() - 1;
        while (l <= r) {
            if (sb.charAt(l++) != sb.charAt(r--))
                return false;
        }
        return true;
    }
}