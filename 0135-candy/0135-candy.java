class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] ans1 = new int[n];
        int[] ans2 = new int[n];

        Arrays.fill(ans1, 1);
        Arrays.fill(ans2, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {

                ans1[i] = ans1[i - 1] + 1;

            }

            else {
                continue;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {

                ans2[i] = ans2[i + 1] + 1;

            }

            else {
                continue;
            }
        }
        for (int i = 0; i < ans1.length; i++) {
            ans1[i] = Math.max(ans1[i], ans2[i]);
        }
        for (int i = 1; i < ans1.length; i++) {
            ans1[i] += ans1[i - 1];
        }

        return ans1[n - 1];
    }
}