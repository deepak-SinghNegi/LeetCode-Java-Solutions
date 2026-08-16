class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new TreeSet<>();
        int n = digits.length;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;

                for (int k = 0; k < n; k++) {
                    if (k == j || k == i)
                        continue;
                    int val = digits[i] * 10;
                    val += digits[j];
                    val *= 10;
                    val += digits[k];
                    if (val % 2 == 0 && val >=100) {
                        set.add(val);
                    }
                }
            }
        }
        int[] arr = new int[set.size()];
        int i = 0;
        for (int x : set) {
            arr[i++] = x;
        }
        return arr;
    }
}