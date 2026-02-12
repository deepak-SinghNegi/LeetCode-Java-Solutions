class Solution {
    public int longestBalanced(String s) {

        int maxWindow = 0;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(freq, 0);
            for (int j = i; j < s.length(); j++) {
                boolean flag = true;
                int val = s.charAt(j) - 'a';
                freq[val]++;

                for (int x : freq) {
                    if (x > 0 && x != freq[val]) {
                        flag = false;
                        break;

                    }
                }
                if (flag) {
                    maxWindow = Math.max(maxWindow, j - i + 1);
                }

            }

        }
        return maxWindow;
    }

}