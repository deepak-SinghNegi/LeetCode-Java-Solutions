// 
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int [] sfreq = new int[26];
        int [] pfreq = new int [26];
        for(int i=0;i<p.length();i++){
            pfreq[p.charAt(i)-'a']++;
        }
        int start = 0;
        int matchFreq = 0;

        int reqMatchFreq = 0;
        for(int i=0;i<26;i++){
            if(pfreq[i]>0)reqMatchFreq++;
        }
        
    for(int end = 0;end<s.length();end++){
        sfreq[s.charAt(end)-'a']++;
        int indx = s.charAt(end)-'a';
        if(sfreq[indx]==pfreq[indx])matchFreq++;
        else if(sfreq[indx]==pfreq[indx]+1)matchFreq--;

       
                
        
        if(end-start+1 == p.length()){
            if (matchFreq == reqMatchFreq) {
                    list.add(start);
                }
            int sIndx = s.charAt(start)-'a';
            if(sfreq[sIndx]==pfreq[sIndx]) matchFreq--;
            else if(sfreq[sIndx]==pfreq[sIndx]+1) matchFreq++;
            sfreq[sIndx]--;
            start++;
            
        }
        if(end - start + 1 == p.length() && matchFreq == reqMatchFreq ) list.add(start);
    }
    return list;
    }
}
