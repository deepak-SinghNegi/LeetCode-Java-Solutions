class Solution {
    public int trap(int[] height) {
        int trapedWater = 0;
        int n = height.length;
        int [] maxLeft = new int [n];
        int [] maxRight  = new int [n];
        maxLeft[0] = height[0];
        maxRight[n-1] = height[n-1];
        for(int i = 1; i< n;i++){
            if(height[i]>maxLeft[i-1]){
                maxLeft[i] = height[i];

            }
            else{
                maxLeft[i] = maxLeft[i-1];
            }
        }
        for(int i = n-2;i>=0;i--){
            if(height[i]>maxRight[i+1]){
                maxRight[i] = height[i];
            }
            else{
                maxRight[i] = maxRight[i+1];
            }
        }
        for(int i=1;i<=n-2;i++){
            int maxWaterHeight = Math.min(maxRight[i],maxLeft[i]);
            trapedWater +=(maxWaterHeight - height[i]);
        }
        return trapedWater;
    }
}