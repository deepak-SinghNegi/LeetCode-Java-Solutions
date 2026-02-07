class Solution {
    public int minimumDeletions(String s) {
       int n = s.length();
        int[] afterA = new int[n];


        int[] beforeB = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            afterA[i] = afterA[i + 1];
            if (s.charAt(i + 1) == 'a') {
                afterA[i]++;
            }
        }
        for (int i = 1; i < beforeB.length; i++) {
            beforeB[i] = beforeB[i-1];
            if(s.charAt(i-1)=='b') {
                beforeB[i]++;
            }
       
        
        }
        int minDel = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
        minDel = Math.min(minDel,afterA[i]+beforeB[i]);
       }
       return minDel;
    }
}