class Solution {
    public int countHomogenous(String s) {
        long count = 1;
        long total =0;
        int mod =1000000007;
        for(int i =1; i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;

            }
            else{
                long val = ((count*(count+1))/2);
                total =(total+val)%mod;
                count = 1;
            }
        }
        long val = ((count*(count+1))/2);

        
        return(int)((total+val)%mod);

    }
}