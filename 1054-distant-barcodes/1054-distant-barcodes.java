class Pair {
    int code;
    int freq;

    public Pair(int code, int freq) {
        this.code = code;
        this.freq = freq;
    }
}

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {

        int n = barcodes.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int code : barcodes) {
            map.put(code, map.getOrDefault(code, 0) + 1);
        }

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> b.freq - a.freq);

        for (int key : map.keySet()) {
            pq.offer(new Pair(key, map.get(key)));
        }

        int ans[] = new int[n];
        int i = 0;
        Pair prev = null;
        while (!pq.isEmpty()) {

            Pair pair = pq.poll();
        
            ans[i++] = pair.code;
            pair.freq--;

            if(prev != null && prev.freq > 0){
                pq.offer(prev);
            }
            prev = pair;
           
        }

        return ans;
    }
}