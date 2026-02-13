class Solution {
    public int garbageCollection(String[] garbage, int[] travel)
    {
        int lastindexP = -1;
        int lastindexM = -1;
        int lastindexG = -1;

       
        for (int i = garbage.length - 1; i >= 0; i--) {
            if (garbage[i].contains("P")) {
                lastindexP = i;
                break;
            }
        }

        
        for (int i = garbage.length - 1; i >= 0; i--) {
            if (garbage[i].contains("M")) {
                lastindexM = i;
                break;
            }
        }

       
        for (int i = garbage.length - 1; i >= 0; i--) {
            if (garbage[i].contains("G")) {
                lastindexG = i;
                break;
            }
        }

        
        int prefix[] = new int[travel.length];
        if (travel.length > 0) {
            prefix[0] = travel[0];
            for (int i = 1; i < travel.length; i++) {
                prefix[i] = travel[i] + prefix[i - 1];
            }
        }

        
        int totalTime = 0;
        for (int i = 0; i < garbage.length; i++) {
            totalTime += garbage[i].length();
        }

       
        if (lastindexP > 0)
            totalTime += prefix[lastindexP - 1];

        if (lastindexM > 0)
            totalTime += prefix[lastindexM - 1];

        if (lastindexG > 0)
            totalTime += prefix[lastindexG - 1];

        return totalTime;
    }
}