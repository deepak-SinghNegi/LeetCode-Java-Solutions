class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum = 0;
        int x = 0;
        for (int i = piles.length - 2; i > x; i -= 2) {
            sum += piles[i];
            x++;
        }
        return sum;
    }
}