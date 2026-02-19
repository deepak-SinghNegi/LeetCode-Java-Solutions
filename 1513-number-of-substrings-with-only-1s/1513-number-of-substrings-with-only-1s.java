class Solution {
    public int numSub(String s) {
        long count = 0;
        long total = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count++;
            }
            else{
                total += ((count*(count+1))/2);
                count = 0;
            }
        }
        total += ((count*(count+1))/2);

        return (int)(total%1000000007);

    }
}