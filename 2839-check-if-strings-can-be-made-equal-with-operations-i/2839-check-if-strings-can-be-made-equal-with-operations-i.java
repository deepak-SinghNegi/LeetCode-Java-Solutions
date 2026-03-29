class Solution {
    public boolean canBeEqual(String s1, String s2) {
        for (int i = 2; i < s1.length(); i++) {
            int j = i - 2;
            char s2CharJ = s2.charAt(j);
            char s2CharI = s2.charAt(i);
            char s1CharJ = s1.charAt(j);
            char s1CharI = s1.charAt(i);
            if (s1CharI != s2CharI || s1CharJ != s2CharJ) {
                if (s1CharJ != s2CharI || s1CharI != s2CharJ)
                    return false;
            }
        }
        return true;
    }
}