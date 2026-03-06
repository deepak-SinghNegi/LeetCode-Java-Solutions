class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        int temp = Math.abs(x);
        long revX = 0;
        while (temp != 0) {
            int last = temp % 10;
            revX *= 10;
            revX += last;
            temp /=10;
        }
        if(revX<Integer.MIN_VALUE || revX > Integer.MAX_VALUE) return 0;
        return (int)(revX * sign);
    }
}