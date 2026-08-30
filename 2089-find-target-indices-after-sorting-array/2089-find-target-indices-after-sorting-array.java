class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int beforeTar = 0;
        int afterTar = 0;
        for(int x : nums){
            if(x < target)
                beforeTar++;
            else if(x > target)
                afterTar++;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = beforeTar; i < nums.length - afterTar; i++){
            list.add(i);
        }
        return list;
    }
}