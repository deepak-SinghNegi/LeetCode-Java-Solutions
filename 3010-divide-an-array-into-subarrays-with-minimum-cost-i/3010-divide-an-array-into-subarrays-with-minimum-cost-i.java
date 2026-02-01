class Solution {
    public int minimumCost(int[] nums) {
        int minCost = nums[0];
        int firstElement = Integer.MAX_VALUE;
        int secondElement = Integer.MAX_VALUE;
        int ptr1 = 1;
        int ptr2 = 1;
        while(ptr1<nums.length ){
            firstElement = Math.min(firstElement,nums[ptr1]);
            
            ptr1++;
            
        }
        ptr1 = 1;
        while(firstElement!=nums[ptr1] ){
            
            
            ptr1++;
            
        }
        while(ptr2<nums.length){
            if(ptr1==ptr2)ptr2++;
            if(ptr2>=nums.length)break;
            
            secondElement = Math.min(secondElement,nums[ptr2]);
            
            ptr2++;
        }
        minCost = minCost+ firstElement+secondElement;
        return minCost;
    }
}