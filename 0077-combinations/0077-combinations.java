class Solution {
    List<List<Integer>> ans = new ArrayList<>(); 
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        
        util(n , k , list , 1);
        return ans;
    }
    private void util(int n , int k , List<Integer> list , int idx){
        if(list.size() == k){
            
            ans.add(new ArrayList<>(list));
            
            return;
        }
        for(int i = idx; i <= n; i++){
            list.add(i);
            util(n , k , list , i+1);
            list.remove(list.size()-1);
        }
    }
}