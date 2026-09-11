class Solution {
    public int findNumbers(int[] nums) {
        int c = 0;
        for (int x : nums) {
            if ((x >= 10 && x < 100) || (x >= 1_000 && x < 10_000) || x == 100_000)
                c++;
        }
        return c;
    }
}