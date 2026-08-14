class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int max = 0;
        for (int r = 0; r < s.length(); r++) {
            char chr = s.charAt(r);
            map.put(chr, map.getOrDefault(chr, 0) + 1);
            while (map.get(chr) > 2) {
                char chl = s.charAt(l);
                map.put(chl, map.get(chl) - 1);
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}