class Solution {
    public int longestSubstring(String s, int k) {
        if(s.length() <k) return 0;
        int freq[] = new int [26];
       
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        
        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);
            if(freq[ch - 'a'] < k){
                int size1 = longestSubstring(s.substring(0 , i) , k);
                int size2 = longestSubstring(s.substring(i+1 , s.length() ) , k);
                int currMax = Math.max(size1 , size2);
                return currMax;
            }
            
            
        }
      return s.length() ;
    }

}