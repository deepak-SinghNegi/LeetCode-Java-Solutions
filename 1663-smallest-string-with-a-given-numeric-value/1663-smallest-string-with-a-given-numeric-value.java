class Solution {
    public String getSmallestString(int n, int k) {
        int[] temp = new int[n];
        Arrays.fill(temp, 1);
        int req = k - n;
        for (int i = n - 1; i >= 0; i--) {
            if (req >= 26) {
                temp[i] = 26;

                req -= 26;
                req += 1;
            } else {
                temp[i] = req + 1;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            sb.append((char) (temp[i] + 96));
        }
        return sb.toString();
    }
}