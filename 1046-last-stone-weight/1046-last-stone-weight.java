class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int i =0;i<stones.length;i++){
            pq.offer(stones[i]);
        }
        while(!pq.isEmpty() && pq.size() > 1){
            int st1 = pq.poll();
            int st2 = pq.poll();
            int val = st1 - st2;
            
            if(val >0)
                pq.offer(val);

            
        }
        if(!pq.isEmpty())
            return pq.poll();
        
        return 0;
    }
}