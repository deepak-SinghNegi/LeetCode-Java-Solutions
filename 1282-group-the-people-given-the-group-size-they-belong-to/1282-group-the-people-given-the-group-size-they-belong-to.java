class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int size = groupSizes[i];
            if (!map.containsKey(size)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(size, list);
            } else {
                List<Integer> list = map.get(size);
                list.add(i);
                map.put(size, list);
            }
        }

        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            List<Integer> group = e.getValue();
            if (group.size() == e.getKey())
                res.add(group);
            else {
                int groups = group.size() / e.getKey();
                int inc = 0;
                for (int i = 0; i < groups; i++) {
                    List<Integer> subGrp = new ArrayList<>();
                    for (int j = inc; j < inc + e.getKey(); j++) {
                        subGrp.add(group.get(j));
                    }
                    inc += e.getKey();
                    res.add(subGrp);
                }
            }
        }
        return res;
    }
}