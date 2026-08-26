class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        int n = nums.length;
        boolean visited[] = new boolean[1001];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int state1 = start + nums[i];
            int state2 = start - nums[i];
            int state3 = start ^ nums[i];
            if (state1 <= 1000 && state1 >= 0) {
                visited[state1] = true;
                q.offer(state1);
            }
            if (state2 <= 1000 && state2 >= 0) {
                visited[state2] = true;
                q.offer(state2);
            }
            if (state3 <= 1000 && state3 >= 0) {
                visited[state3] = true;
                q.offer(state3);
            }
            if (state1 == goal)
                return 1;
            if (state2 == goal)
                return 1;
            if (state3 == goal)
                return 1;
        }
        int op = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (curr == goal)
                    return op;

                for (int j = 0; j < n; j++) {
                    int state1 = curr + nums[j];
                    int state2 = curr - nums[j];
                    int state3 = curr ^ nums[j];
                    if (state1 == goal)
                        return op + 1;
                    if (state2 == goal)
                        return op + 1;
                    if (state3 == goal)
                        return op + 1;
                    if (state1 >= 0 && state1 <= 1000 && !visited[state1]) {
                        visited[state1] = true;
                        q.offer(state1);
                    }
                    if (state2 >= 0 && state2 <= 1000 && !visited[state2]) {
                        visited[state2] = true;
                        q.offer(state2);
                    }
                    if (state3 <= 1000 && state3 >= 0 && !visited[state3]) {
                        visited[state3] = true;
                        q.offer(state3);
                    }
                }
            }
            op++;
        }
        return -1;
    }
}