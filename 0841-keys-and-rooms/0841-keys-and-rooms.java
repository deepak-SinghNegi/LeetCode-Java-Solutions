class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int noOfRooms = rooms.size();
        boolean visitedRoom[] = new boolean[noOfRooms];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visitedRoom[0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            int s = q.poll();
            for (int d : rooms.get(s)) {
                if (!visitedRoom[d]) {
                    visitedRoom[d] = true;
                    q.add(d);
                }
            }
        }
        for (boolean bool : visitedRoom) {
            if (!bool)
                return false;
        }
        return true;
    }
}