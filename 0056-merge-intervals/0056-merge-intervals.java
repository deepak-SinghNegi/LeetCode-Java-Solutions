class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<2)return intervals;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[] > ans = new ArrayList<>();
       ans.add(new int[]{intervals[0][0],intervals[0][1]});
      for(int i=1;i<intervals.length;i++){
        
        int s1 = ans.get(ans.size()-1)[0];
        int e1 = ans.get(ans.size()-1)[1];
        int s2 = intervals[i][0];
        int e2 = intervals[i][1];
        if(e1>=e2)continue;
        if(e1>=s2){
            ans.remove(ans.size()-1);
            ans.add(new int[]{s1,e2});
        }
        else{
            ans.add(new int[]{s2,e2});
        }
      }
      int[][] merge = new int[ans.size()][];
      for(int i=0;i<merge.length;i++){
        merge[i] = ans.get(i);
      }
      return merge;
    }
}