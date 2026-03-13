class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 1;
        for (int val : weights) {
            left = Math.max(left , val);
            right += val;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(mid, weights, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean canShip(int k, int[] arr, int d) {
        int day = 0;
        int i = 0 ;
     while(i<arr.length){
        int wt = 0;

        while(i<arr.length && wt<k){
            wt +=arr[i];
            if(wt<=k)i++;
        }
        day++;
        if(day >d){
            return false;
        }
     }
     return true;
    }
}