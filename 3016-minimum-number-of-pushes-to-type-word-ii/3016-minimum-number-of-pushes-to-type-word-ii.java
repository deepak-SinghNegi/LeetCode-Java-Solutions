class CharAndFreq {
    char ch;
    int count;

    public CharAndFreq(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            freq[ch - 'a']++;
        }
        Arrays.sort(freq);
        int totalPress = 0;
        int unChar = 0;
        for (int i = 25; i >= 0; i--) {
            char ch = (char) ('a' + i);
            if (freq[i] > 0) {
                
                if(unChar <8)
                    totalPress += freq[i];
                else if(unChar <16)
                    totalPress += freq[i]*2;
                else if(unChar <24)
                    totalPress += freq[i]*3;
                else
                    totalPress += freq[i]*4;
                unChar++;
            }

        }
        

        return totalPress;
    }
}