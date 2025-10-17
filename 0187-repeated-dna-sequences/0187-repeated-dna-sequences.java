class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        ArrayList<String>list = new ArrayList<>();
        if (s.length()<=10) return list;
      
         int left = 0;
        HashSet<String> subStrings = new HashSet<>();
        for(int right = 0;right<s.length();right++){
            
            if ( right - left +1 >= 10 ){
                if(subStrings.isEmpty()){
                   subStrings.add(s.substring(left,right+1)); 
                }
                else{
                    if(subStrings.contains(s.substring(left,right+1))){
                        if(!list.contains(s.substring(left,right+1))){
                            list.add(s.substring(left,right+1));
                        }
                    }
                    else{
                        subStrings.add(s.substring(left,right+1));
                    }
                }

                left++;
            }
        }
       

    return list;
    }
}