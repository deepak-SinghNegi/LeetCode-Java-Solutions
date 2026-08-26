class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int l = 0;
        int ones = 0;
        String str = "";
        for (int r = 0; r < n; r++) {
            if (s.charAt(r) == '1')
                ones++;
            while (ones == k) {
                if (str.equals(""))
                    str = s.substring(l, r + 1);
                else if (r - l + 1 < str.length())
                    str = s.substring(l, r + 1);
                else if (r - l + 1 == str.length())
                    str = str.compareTo(s.substring(l, r + 1)) < 0 ? str : s.substring(l, r + 1);

                if (s.charAt(l) == '1')
                    ones--;
                l++;
            }

        }
        return str;
    }

}