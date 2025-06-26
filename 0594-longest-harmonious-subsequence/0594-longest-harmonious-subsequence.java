class Solution {
    public int findLHS(int[] nums) {
    
    HashMap<Integer,Integer> map = new HashMap<>();
    int maxLength = 0;
    for(int i =0; i<nums.length;i++){
        if(map.containsKey(nums[i])){
            map.put(nums[i],map.get(nums[i])+1);

        }
        else{map.put(nums[i],1);}
    }
    //   for (Map.Entry<Integer, Integer> e : map.entrySet()) {
    //      maxLength = Math.max(maxLength, e.getValue());
    //         }
    Set<Integer> keys = map.keySet();
    
   for(int key : keys){
    if(map.containsKey(key+1)){
        maxLength = Math.max(maxLength, map.get(key)+map.get(key+1));
    }
   }
        return maxLength;
    }


}