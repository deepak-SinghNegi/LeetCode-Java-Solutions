class State {
    public int jug1;

    public int jug2;

    public State(int jug1, int jug2) {
        this.jug1 = jug1;
        this.jug2 = jug2;

    }

}


class Solution {
    private State fillJug1(State s, int x) {
    return new State(x, s.jug2);
}

private State fillJug2(State s, int y) {
    return new State(s.jug1, y);
}

private State emptyJug1(State s) {
    return new State(0, s.jug2);

}

private State emptyJug2(State s) {
    return new State(s.jug1, 0);
}

private State pourJug1ToJug2(State s, int x, int y) {
    int pour = Math.min(s.jug1, y - s.jug2);
    return new State(s.jug1 - pour, s.jug2 + pour);

}

private State pourJug2ToJug1(State s, int x, int y) {
    int pour = Math.min(s.jug2, x - s.jug1);
    return new State(s.jug1 + pour, s.jug2 - pour);
}

    public boolean canMeasureWater(int x, int y, int target) {
        HashSet<String> visited = new HashSet<>();
        State s = new State(0, 0);
        Queue<State> q = new LinkedList<>();
        visited.add("0#0");
        q.add(s);
        while (!q.isEmpty()) {
            State curr = q.poll();
            if (curr.jug1 == target || curr.jug2 == target || curr.jug1 + curr.jug2 == target)
                return true;
            State nextStates[] = {
                    fillJug1(curr, x),
                    fillJug2(curr, y),
                    emptyJug1(curr),
                    emptyJug2(curr),
                    pourJug1ToJug2(curr, x, y),
                    pourJug2ToJug1(curr, x, y)
            };
            for (State next : nextStates) {

                String key = next.jug1 + "#" + next.jug2;
                if (!visited.contains(key)) {
                    visited.add(key);
                    q.offer(next);
                }
            }

        }
        return false;
    }
}