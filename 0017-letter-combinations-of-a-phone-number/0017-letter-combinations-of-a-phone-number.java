class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        Stack<String> st = new Stack<>();
        for (char ch : digits.toCharArray()) {
            if (s1.isEmpty())
                s1 = map.get(ch);
            else if (s2.isEmpty())
                s2 = map.get(ch);
            else if (s3.isEmpty())
                s3 = map.get(ch);
            else
                s4 = map.get(ch);
        }
        if (s2.isEmpty()) {
            for (int i = 0; i < s1.length(); i++) {
                res.add(String.valueOf(s1.charAt(i)));
            }

        }
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                String s = String.valueOf(s1.charAt(i)) + String.valueOf(s2.charAt(j));
                res.add(s);
            }
        }
        if (s3.isEmpty())
            return res;
        else if (s4.isEmpty()) {
            List<String> res1 = new ArrayList<>();
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < s3.length(); j++) {
                    String s = res.get(i) + s3.charAt(j);
                    res1.add(s);
                }
            }
            return res1;
        } else {
            List<String> res2 = new ArrayList<>();
            for (int i = 0; i < s3.length(); i++) {
                for (int j = 0; j < s4.length(); j++) {
                    String s = String.valueOf(s3.charAt(i)) + String.valueOf(s4.charAt(j));
                    res2.add(s);
                }

            }
            List<String> finalop = new ArrayList<>();

            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res2.size(); j++) {
                    finalop.add(res.get(i) + res2.get(j));
                }
            }
            return finalop;

        }

    }
}