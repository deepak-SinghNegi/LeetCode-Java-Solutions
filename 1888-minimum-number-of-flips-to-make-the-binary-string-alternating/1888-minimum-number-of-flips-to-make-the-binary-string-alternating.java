class Solution {
    public int minFlips(String s) {
        String ds = s + s;
        int n = s.length();
        int minFilips = Integer.MAX_VALUE;
        int x = 0;
        int currFilips1 = 0;
        int currFilips2 = 0;
        for (int i = 0; i < ds.length(); i++) {
            char ex1 = (i % 2 == 0) ? '0' : '1';
            char ex2 = (i % 2 == 0) ? '1' : '0';
            if (ds.charAt(i) != ex1)
                currFilips1++;
            if (ds.charAt(i) != ex2)
                currFilips2++;

            if (i - x + 1 > n) {
                char l1 = (x % 2 == 0) ? '0' : '1';
                char l2 = (x % 2 == 0) ? '1' : '0';
                if (ds.charAt(x) != l1)
                    currFilips1--;
                if (ds.charAt(x) != l2)
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
