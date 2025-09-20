class Solution {
    public int trap(int[] height) {
        int trapedWater = 0;
        int []maxLeft= new int[height.length];
        maxLeft[0] = height[0];
        for(int i=1;i<maxLeft.length;i++){
            maxLeft[i] = Math.max(height[i],maxLeft[i-1]);
        }
        int[] maxRight = new int[height.length];
        maxRight[maxRight.length-1] = height[height.length-1];
        for(int i = maxRight.length-2;i>=0;i--){
            maxRight[i] = Math.max(height[i], maxRight[i+1]);
        }
        int waterHeight =  0;
        for(int i=1;i<height.length-1;i++){
             waterHeight = Math.min(maxLeft[i],maxRight[i]);
             
            trapedWater += waterHeight-height[i];         
        }
       return trapedWater; 
    }
}