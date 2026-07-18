class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        int l = 0;
        for(int r  =  0; r<n;r++){
            if(r-l+1 > k){
                int lval  = Math.abs(arr[l] - x);
                int rval  = Math.abs(arr[r] - x);
                if(rval < lval){
                    sum -= lval;
                    sum+=rval;
                    ans.remove(0);
                    ans.add(arr[r]);
                }
                l++;
                continue;
            }
            sum += (Math.abs(arr[r] - x));
            ans.add(arr[r]);

        }
        return ans;
    }
}