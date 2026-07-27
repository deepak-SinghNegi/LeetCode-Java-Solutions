class Solution {
    public int maxProduct(int[] nums) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i<nums.length;i++){
            pq.add(nums[i] - 1);
        }
        return pq.poll()*pq.poll();
    }
}