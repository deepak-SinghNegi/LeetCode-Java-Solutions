class Solution {
    public int minFlips(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        StringBuilder ex1 = new StringBuilder();
        StringBuilder ex2 = new StringBuilder();

        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                ex1.append('0');
                ex2.append('1');
            } else {
                ex1.append('1');
                ex2.append('0');
            }
        }
        sb.append(s);
        sb.append(s);

        int minFilips = Integer.MAX_VALUE;
        int x = 0;
        int currFilips1 = 0;
        int currFilips2 = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != ex1.charAt(i))
                currFilips1++;
            if (sb.charAt(i) != ex2.charAt(i))
                currFilips2++;

            if (i - x + 1 > n) {
                if (sb.charAt(x) != ex1.charAt(x))
                    currFilips1--;
                if (sb.charAt(x) != ex2.charAt(x))
                    currFilips2--;
                x++;
            } 
            if (i - x + 1 == n) {
                minFilips = Math.min(Math.min(currFilips1, currFilips2), minFilips);
            }

        }
        

        return minFilips;
    }
}
