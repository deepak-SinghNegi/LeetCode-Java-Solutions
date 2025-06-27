class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
      List<Integer> ans = new ArrayList<>();
      if (s == null || s.length() == 0 || words == null || words.length == 0)
            return ans;
      int wordLen = words[0].length();
      int ArrLength = words.length;
      int StringLength = s.length();
      HashMap<String,Integer> Map = new HashMap<>();
      for(String word : words){
        Map.put(word,Map.getOrDefault(word,0)+1);
      }
      for(int i = 0;i<wordLen;i++){
        int left = i;
        int right = i;
        int count = 0;
        HashMap<String, Integer> NewMap = new HashMap<>();
        while(right+wordLen <= StringLength){
            String str = s.substring(right,right+wordLen);
            right+=wordLen;
            if(Map.containsKey(str)){
                NewMap.put(str,NewMap.getOrDefault(str,0)+1);
                count++;
                
                while(NewMap.get(str)>Map.get(str)){
                    String LeftWord = s.substring(left,left+wordLen);
                    NewMap.put(LeftWord,NewMap.get(LeftWord)-1);
                    count--;
                    left+=wordLen;
                }
                if(count==ArrLength){
                    ans.add(left);
                }
            }
            else{
                NewMap.clear();
                count = 0;
                left=right;
            }
        }

      }
      return ans;
    }
}