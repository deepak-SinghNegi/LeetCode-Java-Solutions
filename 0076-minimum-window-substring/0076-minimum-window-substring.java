class Solution {
    public String minWindow(String s, String t) {
        if (s.equals(t))
            return s;
        int wind = s.length();
        int n = s.length();
        int freq[] = new int[256];
        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }
        int l = 0;
        int size = t.length();
        String ans = "";
        for (int r = 0; r < n; r++) {
            char chr = s.charAt(r);
            if (freq[chr] > 0)
                size--;
            freq[chr]--;
            while (size == 0) {

                char chl = s.charAt(l);
                if (freq[chl] >= 0) {
                    size++;
                    ans = s.substring(l, r + 1);
                    wind = r - l + 1;
                }
                l++;
                freq[chl]++;
            }
            while (r - l + 1 >= wind) {
                char chl = s.charAt(l++);
                if (freq[chl] >= 0) {
                    size++;
                }
                freq[chl]++;

            }

        }

        return ans;
    }
}