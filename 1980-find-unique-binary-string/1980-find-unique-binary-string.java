class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = 1 << nums.length;
        for (int i = 0; i < n; i++) {
            map.put(i, 0);
        }
           
        for (int i = 0; i < nums.length; i++) {
            String s = nums[i];
            int p = 0;
            int val = 0;
            for (int j = s.length() - 1; j >= 0; j--) {
                int v = s.charAt(j) - '0';
                 val += (v * (1 << p));
                
                p++;
            }
            map.put(val, map.get(val) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<nums.length;i++){
            sb.append('0');
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                int key = entry.getKey();
                int x = sb.length()-1;
                while (key > 0) {
                    if (key % 2 == 0) {
                        sb.setCharAt(x,'0');
                    } else {
                        sb.setCharAt(x,'1');
                    }
                    x--;
                    key /= 2;
                }
                break;
            }
        }
        return sb.toString();
    }
}