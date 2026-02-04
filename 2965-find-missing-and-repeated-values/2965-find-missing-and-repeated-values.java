class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int [2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                map.put(grid[i][j],map.getOrDefault(grid[i][j],0)+1);
            }
        }
        int realSum =0;
        for(int key : map.keySet()){
            realSum += key;
            if(map.get(key)==2){
                ans[0] = key;
            }

        }
        int n =(grid.length*grid.length)+1;
        int maxSum = (n*(n-1))/2;
        ans[1] = maxSum - realSum;
        return ans;
    }
}