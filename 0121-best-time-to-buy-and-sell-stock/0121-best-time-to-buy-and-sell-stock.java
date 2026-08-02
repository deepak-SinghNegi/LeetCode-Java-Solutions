class Solution {
    public int maxProfit(int[] prices) {
        int buy = 10001;
        int prof = 0;
        for (int prs : prices) {
            if (prs < buy)
                buy = prs;
            else
                prof = prof > prs - buy ? prof : prs - buy;
        }
        return prof;
    }
}