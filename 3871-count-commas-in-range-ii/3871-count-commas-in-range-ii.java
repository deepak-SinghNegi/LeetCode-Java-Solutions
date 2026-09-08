class Solution {
    public long countCommas(long n) {
        long l1 = 100_0000L;
        long l2 = 100_000_0000L;
        long l3 = 100_000_000_0000L;
        long l4 = 100_000_000_000_0000L;

        int c = 0;
        if (n < 1000)
            return 0;
        if (n < l1)
            return n - 999;
        if (n < l2)
            return 1 + l1 - 999 + 2 * (n - l1);
        if (n < l3)
            return 2 + l1 - 999 + 2 * (l2 - l1) + 3 * (n - l2);
        if (n < l4)
            return 3 + l1 - 999 + 2 * (l2 - l1) + 3 * (l3 - l2) + 4 * (n - l3);
        return  l1 - 999 + 2 * (l2 - l1) + 3 * (l3 - l2) + 4 * (n - l3) + 4;
    }
}