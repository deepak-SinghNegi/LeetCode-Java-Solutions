class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftSum = 0;
        int rightSum = 0;
        int lQ = 0;
        int rQ = 0;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            char left = num.charAt(l++);
            char right = num.charAt(r--);

            if (left == '?')
                lQ++;
            else
                leftSum += left - '0';

            if (right == '?')
                rQ++;
            else
                rightSum += right - '0';
        }
        int diff = Math.abs(rightSum - leftSum);
        int mini = Math.min(rQ, lQ);
        if ((lQ - rQ) % 2 != 0)
            return true;
        lQ -= mini;
        rQ -= mini;
        
        if (lQ > 0) {
            if (rightSum < leftSum)
                return true;
            else {
                int sum = 9 * lQ / 2;
                return sum != diff;
            }
        } else {
            if (rightSum > leftSum)
                return true;
            else {
                int sum = 9 * rQ / 2;
                return sum != diff;
            }
        }

    }
}