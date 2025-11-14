class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0;
        for(int i = 0; i<nums.length;i++){
            int newSum = 0;
            while(i<nums.length && nums[i]==1){
                newSum++;
                i++;
            }
           sum =  Math.max(sum,newSum);
        }
        return sum;
    }
}