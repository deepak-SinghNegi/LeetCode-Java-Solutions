class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int content = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        for (int i = 0; i < g.length; i++) {
            for (int k = j; k < s.length; k++) {
                if (g[i] <= s[k]){
                    
                    content++;
                    j =k+1;
                    break;
                }
                    
            }

        }
        return content;
    }
}