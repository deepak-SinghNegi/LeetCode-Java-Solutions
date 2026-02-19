class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<> ();
        int groupCount = 1;
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                groupCount++;
            }
            else{
                if(groupCount>=3){
                    ArrayList<Integer> x = new ArrayList<>();
                    x.add(i-groupCount);
                    x.add(i-1);
                    ans.add(x);
                    groupCount = 1;
                }
                else{
                    groupCount = 1;
                }
            }
        }
        return ans;
    }
}