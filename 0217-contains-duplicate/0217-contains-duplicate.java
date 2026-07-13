class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            if(set.isEmpty())set.add(n);
            else{
                if(set.contains(n)) return true;
                set.add(n);
            }
        }
        return false;
    }
}