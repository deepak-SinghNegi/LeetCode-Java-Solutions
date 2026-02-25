class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[] temp = new int [n];
        Arrays.sort(arr);
        for(int x = 0; x<n;x++){
            temp[x] = arr[x];
        }
        int maxOne = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = 0;
            while (temp[i] != 0) {
                if ((temp[i] & 1) != 0)
                    val++;
                temp[i] >>= 1;
            }
            maxOne = Math.max(maxOne,val);
            map.put(arr[i], val);
        }
        
        int tePtr = 0;
        
        for (int i = 0; i <= maxOne; i++) {
            int j = 0;
            while (j < n) {
                if (arr[j] == -1) {
                    j++;
                    continue;
                }
                else if (map.get(arr[j]) == i) {
                    temp[tePtr++] = arr[j];
                    arr[j] = -1;
                    j++;
                }
                else{
                    j++;
                    
                }

            }
        }
        return temp;
    }
}