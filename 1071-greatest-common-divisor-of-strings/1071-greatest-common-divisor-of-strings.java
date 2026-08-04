class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        if (!(str1 + str2).equals(str2 + str1))
            return "";
        int len = gcd(n1, n2);

        return str1.substring(0, len);
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}