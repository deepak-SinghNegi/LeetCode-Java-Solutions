import java.util.*;

class Solution {
    
    private static class Interval {
        int start, end, weight, originalIndex;

        Interval(int start, int end, int weight, int originalIndex) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.originalIndex = originalIndex;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            List<Integer> in = intervals.get(i);
            arr[i] = new Interval(in.get(0), in.get(1), in.get(2), i);
        }

        // Break ties by originalIndex for consistent sorting
        Arrays.sort(arr, (a, b) -> {
            if (a.start != b.start) return Integer.compare(a.start, b.start);
            return Integer.compare(a.originalIndex, b.originalIndex);
        });

        int[] nextIndex = new int[n];
        for (int i = 0; i < n; i++) {
            int target = arr[i].end; 
            int low = i + 1, high = n;
            
            // Keep '>' since identical point-intervals overlap
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (arr[mid].start > target) { 
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            nextIndex[i] = low;
        }

        long[][] dp = new long[n + 1][5];
        int[][][] best = new int[n + 1][5][];
        int[] empty = new int[0];
        
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                best[i][k] = empty;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int next = nextIndex[i];
            
            for (int k = 1; k <= 4; k++) {
                long skipWeight = dp[i + 1][k];
                long takeWeight = arr[i].weight + dp[next][k - 1];

                if (takeWeight > skipWeight) {
                    dp[i][k] = takeWeight;
                    best[i][k] = combineAndSort(arr[i].originalIndex, best[next][k - 1]);
                } else if (skipWeight > takeWeight) {
                    dp[i][k] = skipWeight;
                    best[i][k] = best[i + 1][k];
                } else {
                    // TIE BREAKER: Choose the lexicographically smaller path
                    int[] takeChoice = combineAndSort(arr[i].originalIndex, best[next][k - 1]);
                    int[] skipChoice = best[i + 1][k];
                    
                    if (isLexicographicallySmaller(takeChoice, skipChoice)) {
                        dp[i][k] = takeWeight;
                        best[i][k] = takeChoice;
                    } else {
                        dp[i][k] = skipWeight;
                        best[i][k] = skipChoice;
                    }
                }
            }
        }

        return best[0][4]; 
    }

    private int[] combineAndSort(int newElement, int[] existing) {
        int[] res = new int[existing.length + 1];
        res[0] = newElement;
        System.arraycopy(existing, 0, res, 1, existing.length);
        Arrays.sort(res);
        return res;
    }

    private boolean isLexicographicallySmaller(int[] a, int[] b) {
        for (int i = 0; i < Math.min(a.length, b.length); i++) {
            if (a[i] != b[i]) {
                return a[i] < b[i];
            }
        }
        return a.length < b.length;
    }
}