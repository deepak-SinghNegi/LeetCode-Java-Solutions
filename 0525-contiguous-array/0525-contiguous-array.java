class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int prefix = 0;
        int maxSize = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i] == 0 ? -1 : nums[i];
            if(prefix == 0){
                maxSize = Math.max( maxSize, i+1);
            }
            if (map.containsKey(prefix)) {
                maxSize = Math.max(i - map.get(prefix), maxSize);
            } else {
                map.put(prefix, i);
            }
        }
        return maxSize;
    }
}