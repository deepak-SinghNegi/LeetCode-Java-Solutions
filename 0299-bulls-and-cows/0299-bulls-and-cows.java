class Solution {
    public String getHint(String secret, String guess) {
        int numbers[] = new int [10];
        int bull = 0; int cow = 0;
        for(int i = 0; i<secret.length();i++){
            int snum = secret.charAt(i) - '0';
            int gnum = guess.charAt(i) - '0';
            if(snum == gnum)bull++;
            else{
                if(numbers[snum]++ <0)cow++;
                if(numbers[gnum]-- >0) cow++;
            }
        }
        return bull +"A"+cow+"B";
    }
}