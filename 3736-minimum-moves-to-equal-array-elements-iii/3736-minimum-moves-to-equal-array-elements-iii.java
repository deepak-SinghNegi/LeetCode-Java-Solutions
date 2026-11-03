class Solution {
    public int minMoves(int[] nums) {
        int val = -1;
        for(int x : nums){
            val = Math.max(val , x);
        }
        int ans = 0;
        for(int x : nums){
            ans += Math.abs(x - val);
        }
        return ans;
    }
}