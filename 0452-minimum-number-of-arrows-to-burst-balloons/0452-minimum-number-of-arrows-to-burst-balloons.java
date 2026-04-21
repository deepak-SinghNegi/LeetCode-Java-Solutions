class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points , (a,b) -> Integer.compare(a[1], b[1]));
        int c = 1;
        int prev = points[0][1];
        for(int i = 1; i < points.length; i++){
            
            if(prev < points[i][0]){
                System.out.print("x");
                c++;
                prev = points[i][1];
            }
            
        }
        for(int i = 0; i < points.length; i++){
                for(int j = 0; j< 2; j++){
                    System.out.print(points[i][j] +" ");
                }
           System.out.println();
            
        }

        return c;
    }    
}