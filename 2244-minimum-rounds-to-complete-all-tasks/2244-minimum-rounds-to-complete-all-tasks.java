class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : tasks) {
            map.put(num, map.getOrDefault(num, 0) + 1);

        }
        int round = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int temp = 0;
            int x = entry.getValue();
            while (x > 1) {
                if (x - 3 == 0 || x - 3 > 1) {
                    x -= 3;
                } else {
                    x -= 2;
                }
                temp++;
            }
            if (temp == 0)
                return -1;
            round += temp;
        }
        return round;
    }

}