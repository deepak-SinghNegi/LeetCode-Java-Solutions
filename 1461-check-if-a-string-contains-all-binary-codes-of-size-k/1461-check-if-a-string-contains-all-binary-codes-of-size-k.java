class Solution {
    public boolean hasAllCodes(String s, int k) {
        int size = 5;
        if(k==1)
            size = 1;
        else if (k < 4)
            size = 2;
        else if (k >= 4 && k < 16)
            size = 4;
       
        int[] freq = new int[(int)(Math.pow(2, size))];
        for (int i = 0; i < s.length() - size + 1; i++) {
            int j = 0;
            int val = 0;
            int p = size - 1;
            while (j < size) {
                if (s.charAt(i + j) == '1') {
                    val +=(int)( Math.pow(2, p));
                }
                p--;
                j++;
            }
            freq[val]++;
        }
        for (int i = 0; i < freq.length; i++) {
            // System.out.print(freq[i]+" ");
            if (freq[i] == 0)
                return false;
        }
        return true;
    }
}