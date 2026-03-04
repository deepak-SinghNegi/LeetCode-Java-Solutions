class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int size = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.isEmpty()) {
                set.add(ch);

            } else if (set.contains(ch)) {
                set.remove(s.charAt(j++));
                set.add(ch);
            } else {
                set.add(ch);
            }

            size = Math.max(set.size(), size);

        }
        return size;
    }
}