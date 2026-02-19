class Solution {
    public int countStudents(int[] st, int[] sn) {
        int student_0 = 0;
        int student_1 = 0;
        for(int i=0;i<st.length;i++){
            if(st[i] == 0) student_0++;
            else student_1++;
        }
        for(int i = 0;i<sn.length;i++){
            if(sn[i]==0){
                if(student_0>0)student_0--;
                else{
                    break;
                }
                
            }
            else{
                if(student_1>0)student_1--;
                else{
                    break;
                }
            }
        }
        return student_0+student_1;
    }
}