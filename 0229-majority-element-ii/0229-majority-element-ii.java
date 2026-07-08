class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int count1 = 0, count2 = 0, elm1 = Integer.MIN_VALUE, elm2 = Integer.MIN_VALUE;
         int limit = nums.length / 3;
        
        for (int num : nums) {
            if (elm1 == num)
                count1++;
            
            else if (elm2 == num)
                count2++;
            else if (count1 == 0) {
                elm1 = num;
                count1 = 1;
            }
            else if (count2 == 0) {
                elm2= num;
                count2 = 1;
            }
            else{
                 count1--;
                 count2--;
            }
               
        }
        count1 = 0;
        count2 = 0;
        for(int num : nums){
            if(num == elm1) count1++;
            if(num == elm2) count2++;
        }
       
        if(count1 > limit) ans.add(elm1);
        if(count2 > limit) ans.add(elm2);
        return ans;
    }
}