class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int elm1 , elm2 ,c1 ,c2;
        elm1 = elm2 = c1 = c2 =0;
        for(int num : nums){
            if(elm1 == num)c1++;
            else if(elm2 ==num)c2++;
            else if(c1 == 0){
                elm1 = num;
                c1 = 1;
            }
            else if(c2 == 0){
                elm2 = num;
                c2 = 1;
            }
            else{
                c1--;
                c2--;
            }
        }
        c1=c2=0;
        for(int num : nums){
            if(elm1 == num) c1++;
            else if(elm2 == num)c2++;
        }
        List<Integer> list = new ArrayList<>();
        int limit = nums.length / 3;
        if(c1 > limit)list.add(elm1);
        if(c2 > limit)list.add(elm2);
        return list;
    }
}