class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        Boolean Dp[][] = new Boolean[n][n];
        boolean flag = frogJump(stones, 1, 0, 1, Dp, 0);
        return flag;
    }

    private boolean frogJump(int[] stones, int k, int prevStone, int i, Boolean[][] Dp, int pi) {
        if (i == stones.length - 1 && stones[i] == prevStone + k)
            return true;

        else if (i == stones.length - 1 && stones[i] != prevStone + k)
            return false;

        else if (stones[i] < prevStone + k)
            return frogJump(stones, k, prevStone, i + 1, Dp, pi);

        else if (stones[i] > prevStone + k)
            return  false;

        else {
            if (Dp[pi][i] != null)
                return Dp[pi][i];

            return Dp[pi][i] = frogJump(stones, k + 1, stones[i], i + 1, Dp, i) ||
                    frogJump(stones, k - 1, stones[i], i + 1, Dp, i) ||
                    frogJump(stones, k, stones[i], i + 1, Dp, i);
        }
    }
}