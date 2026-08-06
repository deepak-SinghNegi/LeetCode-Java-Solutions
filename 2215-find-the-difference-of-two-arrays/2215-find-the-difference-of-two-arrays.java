class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            res.add(new ArrayList<>());
        }
        for (int i = 0; i < n1; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < n2; i++) {
            set2.add(nums2[i]);
        }
        for (int val : set1) {
            if (!set2.contains(val))
                res.get(0).add(val);
        }
        for (int val : set2) {
            if (!set1.contains(val))
                res.get(1).add(val);
        }
        return res;
    }
}