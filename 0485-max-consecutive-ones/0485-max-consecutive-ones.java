class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int streak = 0;
        int n = nums.length;
        for(int i = 0; i< n;i++){
            int currStreak = 0;
            while(i <n && nums[i] == 1){
                currStreak++;
                i++;
            }
            streak = Math.max(currStreak , streak);
        }
        return streak;
    }
}