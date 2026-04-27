class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : tasks) {
            map.put(num, map.getOrDefault(num, 0) + 1);

        }
        int round = 0;
        for (int x : map.values()) {
            if (x == 1) return -1;
            round += ((x + 2) / 3);
                
        }
        return round;
    }

}