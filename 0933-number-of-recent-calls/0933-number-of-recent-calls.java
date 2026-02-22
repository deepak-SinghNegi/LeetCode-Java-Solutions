class RecentCounter {
    Deque<Integer> queue = new ArrayDeque<>();
    
    public RecentCounter() {
        
    }
    
    public int ping(int t) {
        if(queue.isEmpty()){
            queue.offer(t);
          
            return 1;
        }
        
        queue.offer(t);
      
        if(queue.peekLast() - queue.peek()<=3000){
            return queue.size();
        }
        else{
            while( queue.peekLast() - queue.peek()>3000)
                queue.poll();
            return queue.size();

        }

    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */