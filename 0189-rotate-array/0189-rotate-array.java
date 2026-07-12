class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int f = 0;
        int r = n - 1;
        while(r>=f){
            int temp = nums[f];
            nums[f] = nums[r];
            nums[r] = temp;
            f++;
            r--;
        }
        
        k %=n;
        f = 0;
        r = k-1;
         while(r>f){
            int temp = nums[f];
            nums[f] = nums[r];
            nums[r] = temp;
            f++;
            r--;
        }
        
        f = k;
        r = n-1;
        while(r >=f){
         int temp = nums[f];
            nums[f] = nums[r];
            nums[r] = temp;
            f++;
            r--;
        }
       
    }
}