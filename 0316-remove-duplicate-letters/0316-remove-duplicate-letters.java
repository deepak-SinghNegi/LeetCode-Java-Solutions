class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] freq = new int[26];
        boolean[] used = new boolean[26];
        Stack<Integer> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() &&
                    s.charAt(i) < s.charAt(st.peek()) &&
                    !used[s.charAt(i) - 'a'] &&
                    freq[s.charAt(st.peek()) - 'a'] > 0) {
                int index = st.pop();
                used[s.charAt(index) - 'a'] = false;

            }
            if (!used[s.charAt(i) - 'a']) {
                used[s.charAt(i) - 'a'] = true;
                st.push(i);
            }
            freq[s.charAt(i) - 'a']--;   
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(s.charAt(st.pop()));
        }
        return sb.reverse().toString();
    }
}