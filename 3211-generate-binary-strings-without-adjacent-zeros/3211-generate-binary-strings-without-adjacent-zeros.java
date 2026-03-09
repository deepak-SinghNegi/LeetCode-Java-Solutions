class Solution {
    public List<String> validStrings(int n) {
        List<String> ans =  new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(sb , ans , '1' , n);
        return ans;
        
    }

    public void helper(StringBuilder sb, List<String> list, char prev, int n) {
        if (sb.length() == n) {
            list.add(sb.toString());
            return;
        }
        if (prev == '0') {
            sb.append('1');
            helper(sb, list, '1', n);
            sb.deleteCharAt(sb.length()-1);
            return ;
        }
        sb.append('0');
        helper(sb , list, '0', n);
        sb.deleteCharAt(sb.length()-1);
        sb.append('1');
        helper(sb, list, '1', n);
        sb.deleteCharAt(sb.length()-1);
    }
}