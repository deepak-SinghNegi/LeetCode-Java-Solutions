class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int sum = 0;
        for (int i = n - k; i < n; i++) {   
            sum += cardPoints[i];
        }

        int maxSum = sum;

        int left = n - k;   

        for (int i = 0; i < k; i++) {
            sum -= cardPoints[left++];          
            sum += cardPoints[i];               
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
