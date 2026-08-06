class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer , Integer> map = new HashMap<>();
        Set<Integer> freq = new HashSet<>();
        for(int x : arr){
            map.put(x , map.getOrDefault(x , 0)+1);
        }
        for(int val : map.values()){
            if(freq.contains(val))
            return false;
            freq.add(val);
        }
        return true;
    }
}