class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int size = 0;
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            while (set.contains(ch)) {
                set.remove(s.charAt(j));
                j++;
            }

            set.add(ch);
            size = Math.max(size, set.size());
        }
        return size;
    }
}