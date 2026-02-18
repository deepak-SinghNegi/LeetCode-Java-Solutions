class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int r = 0;
        int l =0;
        int maxSize = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            while (set.contains(ch)) {
                set.remove(s.charAt(l));
                l++;

            }
                set.add(ch);
            
            maxSize = Math.max(maxSize, set.size());
            r++;
        }
        return maxSize;
    }
}