class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int pos = 0;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (mid * mid == x)
                return (int) mid;
            else if (mid * mid < x) {
                pos = pos < mid ? (int) mid : pos;
                l = (int) mid + 1;
            } else
                r = (int) mid - 1;
        }
        return pos;
    }
}