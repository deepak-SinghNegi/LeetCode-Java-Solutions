class Solution {
    public boolean stoneGame(int[] piles) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i< piles.length; i++){
            list.add(piles[i]);
        }
        int a = 0;
        int b = 0;
        
        while(list.size()>0){
            int indx = list.get(0) > list.get(list.size() - 1) ? 0 : list.size() - 1;
            a += list.get(indx);
            list.remove(indx);
            if(list.size() <= 0) break;
            indx = list.get(0) > list.get(list.size() - 1) ? 0 : list.size() - 1;
            b += list.get(indx);
        }

        return a > b;
        
    }
}