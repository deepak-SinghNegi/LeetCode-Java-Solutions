class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < Math.min(k, n1); i++) {
            pq.offer(new int[] { nums1[i] + nums2[0], i, 0 });
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int curr[] = pq.poll();
            int i = curr[1];
            int j = curr[2];
            ans.add(Arrays.asList(nums1[i], nums2[j]));
            if(j+1 <nums2.length)
                pq.offer(new int[]{nums1[i]+nums2[j+1] , i , j+1});

        }
        return ans;
    }
}
    
