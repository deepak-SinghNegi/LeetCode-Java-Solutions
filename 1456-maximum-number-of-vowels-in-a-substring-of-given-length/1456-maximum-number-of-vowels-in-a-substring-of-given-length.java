class Solution {
    public int maxVowels(String s, int k) {
        int maxC = 0;
        int l = 0;
        int count = 0;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                count++;
            while (r - l + 1 >= k) {
                maxC = Math.max(maxC, count);
                char chl = s.charAt(l++);
                if (chl == 'a' || chl == 'e' || chl == 'i' || chl == 'o' || chl == 'u')
                    count--;
            }
        }
        return maxC;
    }
}