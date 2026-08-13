class Solution {

    static class Run {
        int end;
        char ch;

        Run(int end, char ch) {
            this.end = end;
            this.ch = ch;
        }
    }

    TreeMap<Integer, Run> runs = new TreeMap<>();
    TreeMap<Integer, Integer> lengths = new TreeMap<>();

    public int[] longestRepeating(String s, String queryChar, int[] queryInd) {

        int n = s.length();

        int start = 0;

        for (int i = 1; i <= n; i++) {
            if (i == n || s.charAt(i) != s.charAt(i - 1)) {
                addRun(start, i - 1, s.charAt(i - 1));
                start = i;
            }
        }

        int[] ans = new int[queryInd.length];

        for (int q = 0; q < queryInd.length; q++) {

            int idx = queryInd[q];
            char newChar = queryChar.charAt(q);

            Map.Entry<Integer, Run> entry = runs.floorEntry(idx);

            int l = entry.getKey();
            Run old = entry.getValue();

            if (old.ch == newChar) {
                ans[q] = lengths.lastKey();
                continue;
            }

            int r = old.end;
            char oldChar = old.ch;

            removeRun(l);

            if (l <= idx - 1) {
                addRun(l, idx - 1, oldChar);
            }

            if (idx + 1 <= r) {
                addRun(idx + 1, r, oldChar);
            }


            addRun(idx, idx, newChar);

         
            mergeAt(idx);

            ans[q] = lengths.lastKey();
        }

        return ans;
    }

    private void addRun(int l, int r, char ch) {
        if (l > r)
            return;

        runs.put(l, new Run(r, ch));

        int len = r - l + 1;
        lengths.put(len, lengths.getOrDefault(len, 0) + 1);
    }

    private void removeRun(int l) {
        Run run = runs.remove(l);

        int len = run.end - l + 1;

        int count = lengths.get(len);

        if (count == 1)
            lengths.remove(len);
        else
            lengths.put(len, count - 1);
    }

    private void mergeAt(int idx) {

        Map.Entry<Integer, Run> currEntry = runs.floorEntry(idx);

        if (currEntry == null)
            return;

        int currStart = currEntry.getKey();
        Run curr = currEntry.getValue();

        Map.Entry<Integer, Run> leftEntry =
                runs.lowerEntry(currStart);

        if (leftEntry != null) {

            int leftStart = leftEntry.getKey();
            Run left = leftEntry.getValue();

            if (left.end + 1 == currStart &&
                left.ch == curr.ch) {

                removeRun(leftStart);
                removeRun(currStart);

                addRun(leftStart, curr.end, curr.ch);

                currStart = leftStart;
            }
        }
        Map.Entry<Integer, Run> rightEntry =
                runs.higherEntry(currStart);

        if (rightEntry != null) {

            int rightStart = rightEntry.getKey();
            Run right = rightEntry.getValue();

            Run current = runs.get(currStart);

            if (current.end + 1 == rightStart &&
                current.ch == right.ch) {

                removeRun(currStart);
                removeRun(rightStart);

                addRun(currStart, right.end, current.ch);
            }
        }
    }
}