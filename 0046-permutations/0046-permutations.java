class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(new ArrayList<>(), list, nums);
        return list;
    }

    private void helper(List<Integer> list, List<List<Integer>> ans, int[] nums) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList(list));
        }

        else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i]))
                    continue;
                list.add(nums[i]);
                helper(list, ans, nums);
                list.remove(list.size() - 1);
            }
        }

    }
}