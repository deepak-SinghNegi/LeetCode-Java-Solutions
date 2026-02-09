class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        if(target.length==1){
            for(int i=0;i<target[0]-1;i++){
                list.add("Push");
                list.add("Pop");
            }
            list.add("Push");
            return list;
        }
        Stack<Integer> st = new Stack<>();
        int j = 1;
        st.push(j);
        list.add("Push");
        int i=0;
        while(i<target.length && j<n){
            if(st.isEmpty() ){
                st.push(++j);
                list.add("Push");
                i++;
                continue;
            }
            if(  st.peek()==target[i] ){
                i++;
                st.push(++j);
                list.add("Push");
            }
            else{
                st.pop();
                list.add("Pop");
                i--;
            }
            if(i==target.length-1 && target[i]==st.peek())i++;
            
        }
        return list;
    }
}