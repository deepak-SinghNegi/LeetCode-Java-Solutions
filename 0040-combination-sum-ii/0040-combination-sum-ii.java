class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, 0, candidates, target, new ArrayList<>(), 0);
        return ans;
    }

    private void helper(List<List<Integer>> ans, int indx, int[] arr, int target, List<Integer> list, int sum) {

        if (target == sum) {
            ans.add(new ArrayList(list));

            return;
        }
        if (sum > target) {

            return;
        }

        for (int i = indx; i < arr.length; i++) {
            if (i > indx && arr[i] == arr[i - 1])
                continue;
            list.add(arr[i]);
            int newSum = sum + arr[i];

            helper(ans, i + 1, arr, target, list, newSum);

            list.remove(list.size() - 1);
        }
        return;
    }
}