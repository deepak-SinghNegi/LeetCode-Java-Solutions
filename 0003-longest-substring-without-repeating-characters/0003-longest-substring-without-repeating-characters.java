class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r=0;
        int maxLength=0;
        HashSet<Character> ch = new HashSet<>();
        if(s.equals(""))return 0;
        if(s.length()==1)return 1;
        while(r<s.length()){
            
            char c = s.charAt(r);
            while(ch.contains(c)){
                
                ch.remove(s.charAt(l));
                l++;
               
                
               
            }
            ch.add(c);
            int length=ch.size();
            r++;
            
            maxLength = Math.max(length,maxLength);
            
        }
        return maxLength;
        // HashSet<Character> set = new HashSet<>();
        // int ans = 0;
        // int j = 0;

        // for (int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);

           
        //     while (set.contains(ch)) {
        //         set.remove(s.charAt(j));
        //         j++;
        //     }

        //     set.add(ch); 
        //     ans = Math.max(ans, i - j + 1); 
        // }

        // return ans;
    }
}
