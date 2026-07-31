class Solution {

    int dgtLen = 0;
    String[] map;
    public List<String> letterCombinations(String digits) {
        dgtLen = digits.length();
        map = new String[]{
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        lcUtil(res, sb, digits, 0);
        return res;
    }

    private void lcUtil(List<String> res, StringBuilder sb, String digits, int idx) {
        if (idx >= dgtLen) {
            res.add(sb.toString());
            return;
        }
        String s = map[digits.charAt(idx) -'0'];
        for (int i = 0; i < s.length(); i++) {

            sb.append(s.charAt(i));
            lcUtil(res, sb, digits, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}