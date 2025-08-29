class Solution {
    public String minWindow(String s, String t) {
        int sizeOfWindow = Integer.MAX_VALUE;
        int countRequired = t.length();
        HashMap<Character, Integer> map = new HashMap<>();
        String ans = "";
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            
            if (map.containsKey(ch)) {
                if(map.get(ch)>0){
                    countRequired--;
                }
                map.put(ch, map.getOrDefault(ch, 0) - 1);    
            }
           
            while (countRequired == 0) {

                if (sizeOfWindow > right - left + 1) {
                    
                    ans = s.substring(left, right+1);
                    sizeOfWindow = right - left + 1;
                }
                char chleft = s.charAt(left);
                
                
                if(map.containsKey(chleft)){
                    map.put(chleft , map.get(chleft )+1);
                    if(map.get(chleft)>0){
                        countRequired++;
                    }
                    
                }
                left++;
            }

        }

        return ans;
    }

}