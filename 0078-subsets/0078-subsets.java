class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list  = new ArrayList<>() ;
    helper(0 , list, ans , nums);
    return ans ; 
    }
    private void helper(int i , List<Integer> list , List<List<Integer>> ans , int[] nums){
        if(i==nums.length){
            ans.add(new ArrayList<>(list));
            return ;
        }
        list.add(nums[i]);
        helper(i+1 , list , ans , nums);
        list.remove(list.size()-1);
        helper(i+1 , list , ans , nums);

    }
}