class Solution {

    private void paranthesis(int lPar, int rPar, int num, String str , List<String> list) {
      
        if (lPar == num && rPar == num) {
            list.add(str);
            return;
        }
        if (lPar < num) {
            
            paranthesis(lPar + 1, rPar, num, str+"(", list);
           
        }

        if (rPar < lPar) {
           
            paranthesis(lPar, rPar + 1, num, str+")", list);
            
        }
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        paranthesis(0, 0, n, "", list);
        return list;
    }
}