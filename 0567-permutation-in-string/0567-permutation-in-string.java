class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int [] s1Freq = new int[26] ;
        int [] s2Freq = new int[26] ;
        int start = 0;
        int matchReq = 0;
        int matchFound = 0;
        for(int i =0; i<s1.length();i++ ){
            s1Freq[s1.charAt(i) - 'a']++;
        }
        for(int i=0;i<26;i++){
            if(s1Freq[i]>0)matchReq++;
        }

        for(int end = 0;end<s2.length();end++){
            int eIndx = s2.charAt(end)-'a';
            s2Freq[eIndx]++;
            if(s1Freq[eIndx]==s2Freq[eIndx])matchFound++;
            else if(s1Freq[eIndx]+1==s2Freq[eIndx]) matchFound--;

            if(end-start+1 == s1.length()){
                if(matchFound==matchReq){
                    return true;
                }
                int sIndx = s2.charAt(start) - 'a';
                if(s1Freq[sIndx]==s2Freq[sIndx])matchFound--;
                else if(s1Freq[sIndx]+1==s2Freq[sIndx])matchFound++;
                s2Freq[sIndx]--;
                start++;

            }
            if(end-start+1 == s1.length() && matchFound==matchReq){
                return true;
            }
        }
        return false;
    }
}
