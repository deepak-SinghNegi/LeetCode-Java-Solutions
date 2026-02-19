class Solution {
    public int countBinarySubstrings(String s) {
        int count1 =0;
        int count2 = 1;
        int sub =0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count2++;
            }
            else{
                sub += Math.min(count1 , count2);
                count1 = count2;
                count2 = 1;

            }
        }
        sub+=Math.min(count1,count2);
        return sub;
    }
}