class Solution {
    public String truncateSentence(String s, int k) {
        
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        for(int i = 0; i < arr.length; i++){
            if(i == k){
                break;
            }
            sb.append(arr[i] +" ");
        }
        
        return sb.toString().trim();
    }
}