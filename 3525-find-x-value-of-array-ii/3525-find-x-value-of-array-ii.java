class Solution {
    class SegmentTree {
        int[] prod;
        int[][] count;
        int n, k;

        public SegmentTree(int[] nums, int k) {
            this.n = nums.length;
            this.k = k;
            // 4*n is standard safe size for segment tree arrays
            prod = new int[4 * n];
            count = new int[4 * n][k];
            build(1, 0, n - 1, nums);
        }

        private void build(int node, int start, int end, int[] nums) {
            if (start == end) {
                int val = nums[start] % k;
                prod[node] = val;
                count[node][val] = 1;
            } else {
                int mid = start + (end - start) / 2;
                build(2 * node, start, mid, nums);
                build(2 * node + 1, mid + 1, end, nums);
                merge(node, 2 * node, 2 * node + 1);
            }
        }

        private void merge(int node, int left, int right) {
            prod[node] = (prod[left] * prod[right]) % k;
            
            // Start with the prefixes that lie entirely in the left child
            for (int i = 0; i < k; i++) {
                count[node][i] = count[left][i];
            }
            
            // Add prefixes that span across the left child into the right child
            for (int i = 0; i < k; i++) {
                if (count[right][i] > 0) {
                    int newRem = (prod[left] * i) % k;
                    count[node][newRem] += count[right][i];
                }
            }
        }

        public void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                int v = val % k;
                prod[node] = v;
                for (int i = 0; i < k; i++) count[node][i] = 0;
                count[node][v] = 1;
            } else {
                int mid = start + (end - start) / 2;
                if (idx <= mid) {
                    update(2 * node, start, mid, idx, val);
                } else {
                    update(2 * node + 1, mid + 1, end, idx, val);
                }
                merge(node, 2 * node, 2 * node + 1);
            }
        }

        public int[] query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) return null;
            if (l <= start && end <= r) {
                int[] res = new int[k + 1];
                for (int i = 0; i < k; i++) res[i] = count[node][i];
                res[k] = prod[node];
                return res;
            }
            
            int mid = start + (end - start) / 2;
            int[] leftRes = query(2 * node, start, mid, l, r);
            int[] rightRes = query(2 * node + 1, mid + 1, end, l, r);

            if (leftRes == null) return rightRes;
            if (rightRes == null) return leftRes;

            int[] res = new int[k + 1];
            res[k] = (leftRes[k] * rightRes[k]) % k;
            
            for (int i = 0; i < k; i++) res[i] = leftRes[i];
            
            for (int i = 0; i < k; i++) {
                if (rightRes[i] > 0) {
                    int newRem = (leftRes[k] * i) % k;
                    res[newRem] += rightRes[i];
                }
            }
            return res;
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        SegmentTree tree = new SegmentTree(nums, k);
        int[] res = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // 1. Update the segment tree with the new value
            tree.update(1, 0, nums.length - 1, idx, val);
            
            // 2. Query the remaining suffix of the array starting from 'start'
            int[] qRes = tree.query(1, 0, nums.length - 1, start, nums.length - 1);
            
            // 3. Extract the count of prefixes that evaluate to 'x' modulo 'k'
            res[i] = (qRes != null) ? qRes[x] : 0;
        }
        
        return res;
    }
}