class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append('0');
        for (int i = 1; i < n; i++) {
            sb.append('1');
            sb.append(invert(sb.substring(0, sb.length() - 1).toString()));
        }
        

        return sb.charAt(k-1);
    }

    private String invert(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1')
                sb.append('0');
            else
                sb.append('1');
        }
        return sb.toString();
    }
}