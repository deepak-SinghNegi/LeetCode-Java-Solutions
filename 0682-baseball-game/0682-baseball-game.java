class Solution {
    public int calPoints(String[] operations) {
        int sum = 0;
        Stack<Integer> s = new Stack<>();
        int i=0;
        while(i<operations.length){
            if(!operations[i].equals("C") && !operations[i].equals("D") &&!operations[i].equals("+")){
                s.push(Integer.parseInt(operations[i]));
                i++;
            }
            else if(operations[i].equals("C")){
                s.pop();
                i++;
                
                
            }
            else if(operations[i].equals("D")){
               
             
                
                s.push(s.peek()*2);
                i++;
               

            }
            else{
                if(s.size()>=2)
                {
                    Stack<Integer> temp = new Stack<>();
                    temp.addAll(s);
                    int num =temp.peek();
                    temp.pop();
                
                    num+=temp.peek();
                    s.push(num);
                
                i++;
                }
                else{
                    i++;
                }
                }
           

        }
        for(int num : s){
            sum+=num;
        }
    return sum;
    }
}