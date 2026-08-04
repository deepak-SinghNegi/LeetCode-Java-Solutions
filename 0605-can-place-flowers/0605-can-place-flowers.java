class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        if(n ==0) return true;
        if(m < 2 && flowerbed[0] == 0 && n == m ){
            return true;
        }
        int prv = -1;
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                if (flowerbed[i] != 1 && flowerbed[i + 1] != 1) {
                    n--;
                    flowerbed[i] = 1;
                }

            } 
            else if (i == m-1) {
                if (flowerbed[i] != 1 && flowerbed[i - 1] != 1) {
                    n--;
                    flowerbed[i] = 1;
                }

            } 
            else {
                if (flowerbed[i - 1] != 1 && flowerbed[i] != 1 && flowerbed[i + 1] != 1) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
        }
        return n <= 0 ? true : false;
    }
}