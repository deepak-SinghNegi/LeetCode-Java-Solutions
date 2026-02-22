class MyStack {
    Queue<Integer> que1 = new ArrayDeque<>();
    Queue<Integer> que2 = new ArrayDeque<>();

    public MyStack() {

    }

    public void push(int x) {
        if (que1.isEmpty() && que2.isEmpty()) {
            que1.offer(x);
        } else if (!que1.isEmpty() && que2.isEmpty()) {
            que2.offer(x);
            while (!que1.isEmpty()) {
                que2.offer(que1.poll());
            }
        } else if (que1.isEmpty() && !que2.isEmpty()) {
            que1.offer(x);
            while (!que2.isEmpty()) {
                que1.offer(que2.poll());
            }
        }
    }

    public int pop() {
        if (!que1.isEmpty()) {
            return que1.poll();
        } else {
            return que2.poll();
        }
    }

    public int top() {
        if (!que1.isEmpty()) {
            return que1.peek();
        } else {
            return que2.peek();
        }
    }

    public boolean empty() {
        if (que1.isEmpty() && que2.isEmpty())
            return true;
        else
            return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */