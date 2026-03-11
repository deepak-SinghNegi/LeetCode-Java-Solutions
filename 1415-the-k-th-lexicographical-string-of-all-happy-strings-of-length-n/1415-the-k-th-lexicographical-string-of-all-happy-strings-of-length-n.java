class Solution {
     private void helper(List<String> list, StringBuilder sb, int n, int k, char prev) {
        sb.append(prev);
        if (sb.length() >= n) {
            list.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        if (prev == 'a') {

            helper(list, sb, n, k, 'b');
            helper(list, sb, n, k, 'c');
            sb.deleteCharAt(sb.length() - 1);
        } else if (prev == 'b') {
            helper(list, sb, n, k, 'a');
            helper(list, sb, n, k, 'c');
            sb.deleteCharAt(sb.length() - 1);

        } else if (prev == 'c') {
            helper(list, sb, n, k, 'a');
            helper(list, sb, n, k, 'b');
            sb.deleteCharAt(sb.length() - 1);

        }

    } 
    public String getHappyString(int n, int k) {
        List<String> ls = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(ls, sb, n, k, 'a');
       
        if (ls.size() >= k) {
            return ls.get(k-1);
        }
        helper(ls, sb, n, k, 'b');
       
        if (ls.size() >= k) {
            return ls.get(k-1);
        }
        helper(ls, sb, n, k, 'c');
        

        if(k <= ls.size()){
            return ls.get(k-1);
        }
        else{
            return "";
        }

    }

}