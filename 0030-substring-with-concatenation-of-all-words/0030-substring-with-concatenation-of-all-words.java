class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length;
        int m = words[0].length();
        int windSize = n * m;
        Map<String, Integer> map1 = new HashMap<>();
        for (String x : words) {
            map1.put(x, map1.getOrDefault(x, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        

        int l = 0;
       
        for (int r = 0; r < s.length(); r++) {

            
            while (r - l + 1 >= windSize) {
                String str = s.substring(l , r+1);
                Map<String, Integer> map2 = new HashMap<>();
                
                for (int j = 0; j< windSize; j+=m) {
                    String sb = str.substring(j, j + m);
                    map2.put(sb, map2.getOrDefault(sb, 0) + 1);
                    
                }
                if (map1.equals(map2))
                    res.add(l);
                l++;
            }
        }
        return res;
    }
}