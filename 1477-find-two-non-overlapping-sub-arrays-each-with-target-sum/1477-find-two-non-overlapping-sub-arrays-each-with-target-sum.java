class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int INF = Integer.MAX_VALUE / 2;

        int[] best = new int[n];
        Arrays.fill(best, INF);

        HashMap<Integer, Integer> map = new HashMap<>();

        // prefix sum 0 exists before the array starts
        map.put(0, -1);

        int prefix = 0;
        int answer = INF;

        for (int i = 0; i < n; i++) {

            prefix += arr[i];

            // Carry forward the best subarray found so far
            if (i > 0) {
                best[i] = best[i - 1];
            }

            // Need previous prefix = prefix - target
            if (map.containsKey(prefix - target)) {

                int j = map.get(prefix - target);

                // Current subarray: j+1 ... i
                int length = i - j;

                // Check if another non-overlapping subarray exists
                if (j >= 0 && best[j] != INF) {
                    answer = Math.min(answer, length + best[j]);
                }

                // This is the shortest target subarray ending at i
                best[i] = Math.min(best[i], length);
            }

            // Store latest prefix index
            map.put(prefix, i);
        }

        return answer == INF ? -1 : answer;
    }
}