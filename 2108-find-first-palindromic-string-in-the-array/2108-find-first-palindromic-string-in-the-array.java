class Solution {
    public String firstPalindrome(String[] words) {
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String s = words[i];
            int a = 0;
            int b = s.length() - 1;
            while (a <= b && s.charAt(a) == s.charAt(b)) {
                a++;
                b--;
            }
            if (a >= b)
                return s;
        }
        return "";
    }
}