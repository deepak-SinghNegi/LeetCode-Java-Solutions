class Solution {

    private long[] digitFactors(int d) {
        switch (d) {
            case 2: return new long[]{1, 0, 0, 0};
            case 3: return new long[]{0, 1, 0, 0};
            case 4: return new long[]{2, 0, 0, 0};
            case 5: return new long[]{0, 0, 1, 0};
            case 6: return new long[]{1, 1, 0, 0};
            case 7: return new long[]{0, 0, 0, 1};
            case 8: return new long[]{3, 0, 0, 0};
            case 9: return new long[]{0, 2, 0, 0};
            default: return new long[]{0, 0, 0, 0}; 
        }
    }

    private long[] add(long[] a, long[] b) {
        long[] r = new long[4];
        for (int i = 0; i < 4; i++) r[i] = a[i] + b[i];
        return r;
    }

    private long[] subtractClip(long[] a, long[] b) {
        long[] r = new long[4];
        for (int i = 0; i < 4; i++) r[i] = Math.max(0, a[i] - b[i]);
        return r;
    }
    private List<Integer> minimalDigits(long[] need) {
        long e2 = need[0], e3 = need[1], e5 = need[2], e7 = need[3];
        List<Integer> digits = new ArrayList<>();

        for (long i = 0; i < e5; i++) digits.add(5);
        for (long i = 0; i < e7; i++) digits.add(7);

        long nines = e3 / 2, remThree = e3 % 2;
        for (long i = 0; i < nines; i++) digits.add(9);

        long eights = e2 / 3, remTwo = e2 % 3;
        for (long i = 0; i < eights; i++) digits.add(8);

        long combine = Math.min(remTwo, remThree); // 0 or 1
        for (long i = 0; i < combine; i++) digits.add(6);
        remTwo -= combine;
        remThree -= combine;

        long fours = remTwo / 2, twos = remTwo % 2;
        for (long i = 0; i < fours; i++) digits.add(4);
        for (long i = 0; i < twos; i++) digits.add(2);
        for (long i = 0; i < remThree; i++) digits.add(3);

        return digits;
    }

    public String smallestNumber(String num, long t) {
        long[] need = new long[4];
        long rem = t;
        int[] primes = {2, 3, 5, 7};
        for (int p = 0; p < 4; p++) {
            while (rem % primes[p] == 0) {
                need[p]++;
                rem /= primes[p];
            }
        }
        if (rem != 1) return "-1"; 

        int n = num.length();
        List<Integer> minimalOverall = minimalDigits(need);
        int minLen = minimalOverall.size();

        if (minLen > n) {
            Collections.sort(minimalOverall);
            StringBuilder sb = new StringBuilder();
            for (int d : minimalOverall) sb.append(d);
            return sb.toString();
        }

        int firstZero = -1;
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '0') { firstZero = i; break; }
        }

        if (firstZero == -1) {
            long[] prod = new long[4];
            for (int i = 0; i < n; i++) prod = add(prod, digitFactors(num.charAt(i) - '0'));
            boolean ok = true;
            for (int i = 0; i < 4; i++) if (prod[i] < need[i]) { ok = false; break; }
            if (ok) return num;
        }

        int maxI = (firstZero == -1) ? n - 1 : firstZero;

        long[][] prefixProd = new long[n + 1][4];
        for (int i = 0; i < n; i++) {
            prefixProd[i + 1] = add(prefixProd[i], digitFactors(num.charAt(i) - '0'));
        }

        for (int i = maxI; i >= 0; i--) {
            int startDigit = (num.charAt(i) - '0') + 1;
            for (int d = startDigit; d <= 9; d++) {
                long[] used = add(prefixProd[i], digitFactors(d));
                long[] remaining = subtractClip(need, used);
                List<Integer> fillDigits = minimalDigits(remaining);
                int available = n - i - 1;
                if (fillDigits.size() <= available) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append(d);
                    int ones = available - fillDigits.size();
                    for (int k = 0; k < ones; k++) sb.append('1');
                    Collections.sort(fillDigits);
                    for (int fd : fillDigits) sb.append(fd);
                    return sb.toString();
                }
            }
        }
        List<Integer> digitsFull = minimalDigits(need);
        int L = n + 1;
        int ones = L - digitsFull.size();
        Collections.sort(digitsFull);
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < ones; k++) sb.append('1');
        for (int fd : digitsFull) sb.append(fd);
        return sb.toString();
    }
}