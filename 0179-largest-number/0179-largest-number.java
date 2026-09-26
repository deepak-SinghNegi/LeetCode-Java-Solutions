class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        int zero = 0;
        for(int x : nums){
            if(x == 0)zero++;
        }
        if(zero == n) return "0";
        String[] strNums = new String[n];
        for (int i = 0; i < n; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
        for (String s : strNums) {
            sb.append(s);
        }
        return sb.toString();
    }
}