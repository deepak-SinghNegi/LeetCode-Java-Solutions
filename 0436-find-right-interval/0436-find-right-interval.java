class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        TreeMap<Integer , Integer> map = new TreeMap<>();
        for(int i = 0; i<n;i++){
            map.put(intervals[i][0] , i);
        }
        int ans[] = new int [n];
        for(int i = 0; i<n;i++){
            int end = intervals[i][1];
            ans [i] = map.ceilingEntry(end) ==null ? -1 :map.ceilingEntry(end).getValue() ;
        }
        return ans;
    }
}