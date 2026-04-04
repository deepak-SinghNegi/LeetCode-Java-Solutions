class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int balls = 0;
        int [] prifix = new int [n];
        for(int i = 1; i < n; i++){
            if(boxes.charAt(i - 1) - '0' == 1) balls++;
            prifix[i] = prifix[i-1] + balls;
        }
        int [] suffix = new int [n];
        balls = 0;
        for(int i = n-2; i >= 0; i--){
            if(boxes.charAt(i + 1) - '0' == 1) balls++;

            suffix[i] = suffix[i+1] + balls;
        }
        int [] ans = new int [n];

        for(int i = 0; i < n; i++){
            ans[i] = suffix[i] + prifix[i];
        }
        return ans;
    }
}