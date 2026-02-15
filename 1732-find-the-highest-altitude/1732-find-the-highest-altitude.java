class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0 > gain[0] ? 0 : gain[0];
        int[] prifix = new int[gain.length];
        prifix[0] = gain[0];
        for (int i = 1; i < gain.length; i++) {
            prifix[i] = prifix[i - 1] + gain[i];
            sum = Math.max(prifix[i], sum);
        }
        return sum;
    }
}