class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int mid = l + (r - l) / 2;

        while (l <= mid && r >= mid) {
            if (l == r) {
                if (l == 0)
                    break;
                if (nums[l] > nums[l - 1] && nums[l] > nums[l + 1])
                    return l;
            }
            else{
             if (l == 0 || r == nums.length - 1) {
                if (nums[l] > nums[l + 1])
                    return l;
                if (nums[r] > nums[r - 1])
                    return r;
                } 
                else {
                    if (nums[l] > nums[l - 1] && nums[l] > nums[l + 1])
                        return l;
                    if (nums[r] > nums[r + 1] && nums[r] > nums[r - 1])
                        return r;
                }
           }
            l++;
            r--;
        }

        return 0;
    }
}