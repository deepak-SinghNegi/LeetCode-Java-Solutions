class Solution {
    public List<String> validStrings(int n) {
        List<String> ans =  new ArrayList<>();
        helper("" , ans , '1' , n);
        return ans;
        
    }

    public void helper(String s, List<String> list, char prev, int n) {
        if (s.length() == n) {
            list.add(s);
            return;
        }
        if (prev == '0') {
            helper(s + '1', list, '1', n);
            return ;
        }
        helper(s + '0', list, '0', n);
        helper(s + '1', list, '1', n);
    }
}