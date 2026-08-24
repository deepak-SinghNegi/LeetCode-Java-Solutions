class Solution {
    public boolean equalFrequency(String word) {

        int[] freq = new int[26];

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int f : freq) {
            if (f != 0) {
                map.put(f, map.getOrDefault(f, 0) + 1);
            }
        }

        if (map.size() == 1) {
            int frequency = map.keySet().iterator().next();
            return frequency == 1 || map.get(frequency) == 1;
        }

        if (map.size() != 2) {
            return false;
        }

        int f1 = 0;
        int f2 = 0;

        for (int f : map.keySet()) {
            if (f1 == 0)
                f1 = f;
            else
                f2 = f;
        }

        int count1 = map.get(f1);
        int count2 = map.get(f2);

      
        if (f1 == 1 && count1 == 1)
            return true;

        if (f2 == 1 && count2 == 1)
            return true;

        if (f1 == f2 + 1 && count1 == 1)
            return true;

        if (f2 == f1 + 1 && count2 == 1)
            return true;

        return false;
    }
}