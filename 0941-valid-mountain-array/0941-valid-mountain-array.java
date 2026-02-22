class Solution {
    public boolean validMountainArray(int[] arr) {
        boolean flag = false;
        if(arr.length<=2 || arr[0]>=arr[1])return false;
        for(int i = 1;i<arr.length;i++){
            if(arr[i]==arr[i-1])return false;
            if(arr[i]<arr[i-1]) flag =true;
            if(flag){
                if(arr[i]>=arr[i-1])return false;
            }
        }
        return flag ? true : false;
    }
}