class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int l = 0;
        int c = 0;
        int i = 0;
        for (int r = 0; r < n; r++) {
            if (!(chars[l] == chars[r])) {
                if (r - l > 1) {
                    chars[i++] = chars[l];
                    c++;
                    int val = r - l;
                    if (val >= 10) {
                        String digits = String.valueOf(val);

                        for (int j = 0; j < digits.length(); j++) {

                            chars[i++] = digits.charAt(j);
                            c++;
                        }
                    } else {
                        chars[i++] = (char) ('0' + (r - l));
                        c++;
                    }
                } else {
                    c++;
                    chars[i++] = chars[l];
                }
                l = r;
            }
        }
        if (n - l > 1) {
            chars[i++] = chars[l];
            c++;
            int val = n - l;
            if (val >= 10) {
                String digits = String.valueOf(val);

                for (int j = 0; j < digits.length(); j++) {

                    chars[i++] = digits.charAt(j);
                    c++;
                }
            } else {

                chars[i++] = (char) ('0' + (n - l));
                c++;
            }
        } else {
            c++;
            chars[i++] = chars[l];
        }

        return c;
    }
}