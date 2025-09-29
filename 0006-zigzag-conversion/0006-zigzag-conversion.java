class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || numRows >= s.length()) return s;

        StringBuilder sb = new StringBuilder();
        int mainJump = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += mainJump) {
                sb.append(s.charAt(j)); // vertical part

                // diagonal part for middle rows
                int diagIdx = j + mainJump - 2 * i;
                if (i > 0 && i < numRows - 1 && diagIdx < s.length()) {
                    sb.append(s.charAt(diagIdx));
                }
            }
        }
        return sb.toString();
    }
}