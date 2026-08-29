class Solution {
    int[] parent;
    int[] rank;

    private int find(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    private void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb)
            return;

        if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        } else if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));


        for (int i = 1; i < n; i++) {

            int previousValue = arr[i - 1][0];
            int currentValue = arr[i][0];

            if (currentValue - previousValue <= limit) {
                union(arr[i - 1][1], arr[i][1]);
            }
        }

      
        Map<Integer, List<Integer>> indices = new HashMap<>();

        
        Map<Integer, PriorityQueue<Integer>> values = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int root = find(i);

            indices.computeIfAbsent(root, x -> new ArrayList<>()).add(i);

            values
                .computeIfAbsent(root, x -> new PriorityQueue<>())
                .offer(nums[i]);
        }

        int[] ans = new int[n];

    
        for (int root : indices.keySet()) {

            List<Integer> idx = indices.get(root);
            PriorityQueue<Integer> pq = values.get(root);

            for (int i : idx) {
                ans[i] = pq.poll();
            }
        }

        return ans;
    }
}