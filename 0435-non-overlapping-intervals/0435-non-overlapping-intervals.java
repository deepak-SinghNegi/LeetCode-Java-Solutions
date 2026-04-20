class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]); 
        int n = intervals.length;
        int prev = intervals[0][1];
        int c = 0;
        for(int i = 1 ;i < n; i++){
            if(prev > intervals[i][0]) c++;
            else{
                prev = intervals[i][1];
            }
        }
        return c;
    }
    
}