class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        if(s1.length()==1 && s2.length()==1){
            if(s2.charAt(0)==s1.charAt(0)){
                return true;
            }
            return false;
        }
       HashMap<Character,Integer> subStr = new HashMap<>();
       for(int i=0;i<s1.length();i++){
        char ch = s1.charAt(i);
        subStr.put(ch,subStr.getOrDefault(ch,0)+1);
       }
       HashMap<Character,Integer> window = new HashMap<>();
       int left = 0;
       int right = 0;
       while(right<s2.length()){
        char ch = s2.charAt(right);
        window.put(ch,window.getOrDefault(ch,0)+1);
        if(right-left+1 > s1.length()){
            char toRemove = s2.charAt(left);
            window.put(toRemove, window.get(toRemove) - 1);
            if(window.get(toRemove)==0){
                window.remove(toRemove);
            }
            left++;
        }
        if(right-left+1==s1.length()&&subStr.equals(window)){
            return true;
        }
       right++;
       }
       return false;
    }
}
