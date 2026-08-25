class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int n = 0;

    public int minJumps(int[] arr) {
        n = arr.length;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[n];
        int jump = 0;
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int idx = q.poll();
                if (idx == n - 1)
                    return jump;
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    q.add(idx - 1);
                    visited[idx - 1] = true;
                }
                if (idx + 1 < n && !visited[idx + 1]) {
                    q.add(idx + 1);
                    visited[idx + 1] = true;
                }
                    List<Integer> list = map.get(arr[idx]);
                if (list != null) {
                    for (int x : list) {
                        if (!visited[x]) {
                            q.add(x);
                            visited[x] = true;
                        }
                        map.remove(arr[x]);
                    }
                }
            }
            jump++;
        }
        return jump;
    }

}