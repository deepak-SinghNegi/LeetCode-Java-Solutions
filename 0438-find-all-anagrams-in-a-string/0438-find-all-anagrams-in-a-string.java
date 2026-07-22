class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int freq[] = new int[26];
        for(char ch : p.toCharArray()){
            freq[ch - 'a']++;

        }
        List<Integer> list = new ArrayList<>();
        int size = p.length();
        int l = 0;
        for(int r = 0; r<s.length() ; r++){
            char chr = s.charAt(r);
            if(freq[chr - 'a'] > 0)
                size--;
            freq[chr - 'a']--;

            if(size == 0){
                char chl = s.charAt(l);
                list.add(l++);
                size++;
                freq[chl - 'a']++;
            }
            if(r - l +1 >= p.length()){
                char chl = s.charAt(l++);
                if(freq[chl -'a'] >=0)
                    size++;
                freq[chl -'a']++; 

            }
        }
        return list;
    }
}