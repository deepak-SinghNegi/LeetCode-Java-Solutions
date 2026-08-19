class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < reservedSeats.length; i++) {
            int row = reservedSeats[i][0];
            int sheat = reservedSeats[i][1];
            if (map.containsKey(row)) {
                map.get(row).add(sheat);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(sheat);
                map.put(row, list);
            }
        }
        int maxBooking = 0;
        for (List<Integer> list : map.values()) {
            
                Set<Integer> set = new HashSet<>();
                for (int x : list)
                    set.add(x);
                boolean left = !set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5);

                boolean middle = !set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7);

                boolean right = !set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9);
                if (left && right)
                    maxBooking += 2;
                else if (left || middle || right)
                    maxBooking += 1;

            
        }
        return maxBooking + (n - map.size())*2;
    }
}