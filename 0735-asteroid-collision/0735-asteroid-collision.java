class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>0)st.push(asteroids[i]);
            else{
                
                while((!st.isEmpty()&&st.peek()<Math.abs(asteroids[i]))){
                    if(st.peek()>0){
                        st.pop();
                    }
                    else{
                        st.push(asteroids[i]);
                        break;
                    }
                    
                }
                
                if(st.isEmpty())st.push(asteroids[i]);
                if(st.peek()==Math.abs(asteroids[i])) st.pop();
                
            }
        }
        int [] ans = new int [st.size()];
        int i =st.size()-1;
        while(!st.isEmpty()){
           ans[i] =  st.pop();
           i--;
        }
        return ans;
    }
}