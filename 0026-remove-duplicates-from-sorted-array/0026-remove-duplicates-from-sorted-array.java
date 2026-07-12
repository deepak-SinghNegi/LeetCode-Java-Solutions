class Solution {
    public int removeDuplicates(int[] nums) {
        int x = 1;
        int val = nums[0];
        int n = nums.length;
        if(n==1) return x;
        for(int i=1;i<n;i++){
            if(val != nums[i]){
               
                val = nums[i];
                nums[x++] = val;
            }
        }
        return x;
    }
}