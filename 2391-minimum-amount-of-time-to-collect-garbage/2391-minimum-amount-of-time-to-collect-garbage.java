class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int p = -1;
        int m = -1;
        int g = -1;
        int travelTime = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (garbage[i].contains("G")) {
                g = i;
                break;
            }

        }
        System.out.println(g);
        for (int i = n - 1; i >= 0; i--) {
            if (garbage[i].contains("M")) {
                m = i;
                break;
            }

        }
        System.out.println(m);
        for (int i = n - 1; i >= 0; i--) {
            if (garbage[i].contains("P")) {
                p = i;
                break;
            }

        }
        System.out.println(p);
        for (int i = 0; i <= g; i++) {
            int l = garbage[i].length();
            for (int j = 0; j < l; j++) {
                if (garbage[i].charAt(j) == 'G')
                    travelTime++;
            }
            if(i>=1)travelTime += travel[i-1];
        }
        for (int i = 0; i <= m; i++) {
            int l = garbage[i].length();
            for (int j = 0; j < l; j++) {
                if (garbage[i].charAt(j) == 'M')
                    travelTime++;
            }
            if(i>=1)travelTime += travel[i-1];

        }
        for (int i = 0; i <= p; i++) {
            int l = garbage[i].length();
            for (int j = 0; j < l; j++) {
                if (garbage[i].charAt(j) == 'P')
                    travelTime++;
            }
            if(i>=1)travelTime += travel[i-1];

        }
        return travelTime;
    }
}