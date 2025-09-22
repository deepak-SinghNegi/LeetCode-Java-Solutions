class Solution {
    private int robbing1(int[] nums ,int i,int j,int[]Dp){
        if(i>=j) return 0 ;
    
            if(Dp[i]!=-1)return Dp[i];
            int steal = nums[i]+robbing1(nums,i+2,j,Dp);
       
            int skip = robbing1(nums,i+1,j,Dp);
            return  Dp[i]=Math.max(skip,steal);
    }
    private int robbing2(int[] nums ,int i,int j,int []Dp){
        if(i>=j) return 0 ;
    
            if(Dp[i]!=-1)return Dp[i];
            int steal = nums[i]+robbing2(nums,i+2,j,Dp);
       
            int skip = robbing2(nums,i+1,j,Dp);
            return  Dp[i]=Math.max(skip,steal);
    }
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        int [] Dp1 = new int[nums.length+1];
        Arrays.fill(Dp1,-1);
        int [] Dp2 = new int[nums.length+1];
        Arrays.fill(Dp2,-1);
        int rob1 =  robbing1(nums,0,nums.length-1,Dp1);
        // System.out.println(rob1);
        int rob2 = robbing2(nums,1,nums.length,Dp2);
        // System.out.println(rob2);
        return Math.max(rob1, rob2);
    }
}