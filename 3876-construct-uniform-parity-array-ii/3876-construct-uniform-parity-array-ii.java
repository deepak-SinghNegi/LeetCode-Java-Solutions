class Solution {
    public boolean uniformArray(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int minOdd = Integer.MAX_VALUE;
        boolean hasEven = false;
        boolean hasOdd = false;

        for (int num : nums) {
            if (num % 2 == 0) {
                hasEven = true;
            } else {
                hasOdd = true;
                minOdd = Math.min(minOdd, num);
            }
            minVal = Math.min(minVal, num);
        }
        if (!hasEven || !hasOdd) {
            return true;
        }
        return minVal % 2 != 0;
    }
}