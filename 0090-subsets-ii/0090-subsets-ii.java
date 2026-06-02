class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set  = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(0 , nums , set , list);
        for (List<Integer> x : set) {
            ans.add(x);
        }   
        return ans;

    }
    private void helper(int i , int [] nums , HashSet<List<Integer>> set , List<Integer> list ){
        if(i>=nums.length){
            set.add(new ArrayList(list));
            return;
        }
        list.add(nums[i]);
        helper(i+1 , nums , set , list);
        list.remove(list.size()-1);
        helper(i+1 , nums , set , list);
    }
}