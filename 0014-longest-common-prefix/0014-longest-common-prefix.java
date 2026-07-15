class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        int j = 0;
        StringBuilder sb = new StringBuilder();
        int minLimit = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++)
            minLimit = Math.min(minLimit, strs[i].length());
        while (minLimit > j) {
            char commonCh = strs[0].charAt(j);
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].charAt(j) != commonCh)
                    return sb.toString();
            }
            sb.append(commonCh);
            j++;
        }
        return sb.toString();
    }
}