class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int finalSum = arr[0];
        for (int i = 1; i < n; i++) {
            finalSum += arr[i];
        }
        int size = 3;

        while (size <= n) {
            int sum = 0;
            for (int i = 0; i < size; i++) {
                sum += arr[i];
            }
            finalSum += sum;
            for (int i = size; i < n; i++) {
                sum -= arr[i - size];
                sum += arr[i];
                finalSum += sum;
            }
            size += 2;
        }
        return finalSum;
    }
}