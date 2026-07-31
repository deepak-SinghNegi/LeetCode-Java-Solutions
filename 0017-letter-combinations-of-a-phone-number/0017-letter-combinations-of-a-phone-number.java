class Solution {
        HashMap<Character, String> map = new HashMap<>();
        int dgtLen = 0;
    public List<String> letterCombinations(String digits) {
        dgtLen = digits.length();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        lcUtil(res , sb ,digits , 0 );
        return res;
    }
    private void lcUtil(List<String> res ,StringBuilder sb,String digits , int idx){
        if(idx >= dgtLen){
            res.add(sb.toString());
            return;
        }
        String s = map.get(digits.charAt(idx));
        for(int i =0; i<s.length();i++){
            
            sb.append(s.charAt(i));
            lcUtil(res , sb , digits , idx+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}