class Solution {
    private int windowSize(int num) {
        int size = 0;
        while (num > 0) {
            size++;
            num /= 10;
        }
        return size;
    }

    public List<Integer> sequentialDigits(int low, int high) {
        int highDigits = windowSize(high);
        int lowDigits = windowSize(low);
        List<Integer> list = new ArrayList<>();
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        for (int window = lowDigits; window <= highDigits; window++) {
            int left = 0;
            int digit = 0;
            for (int right = 0; right < 9; right++) {
                digit *= 10;
                digit += nums[right];
                if (right - left + 1 >= window) {
                    if (digit <= high && digit >= low)
                        list.add(digit);
                    int remove =(int) Math.pow(10 , window - 1);
                    digit -=( remove*nums[left]);
                    left++;
                }
            }
        }
        return list;
    }
}