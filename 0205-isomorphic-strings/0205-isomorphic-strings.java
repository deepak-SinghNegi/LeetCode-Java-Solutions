class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character , Character> map = new HashMap<>();
        for(int i = 0; i<s.length();i++){
            if(!map.containsKey(s.charAt(i)) && map.containsValue(t.charAt(i)))return false;
            map.put(s.charAt(i) , t.charAt(i));
            
        }
        StringBuilder sb  = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            sb.append(map.get(s.charAt(i)));
        }
        return sb.toString().equals(t);
    }
}