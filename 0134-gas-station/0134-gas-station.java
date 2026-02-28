class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int fule = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            fule += diff;
            total += diff;
            if (fule < 0) {
                start = i + 1;
                fule = 0;
            }

        }
        return total >= 0 ? start : -1;
    }
}