class CharAndFreq {
    char ch;
    int count;

    public CharAndFreq(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

class Solution {
    public int minimumPushes(String word) {
        PriorityQueue<CharAndFreq> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        int[] freq = new int[26];
        int totalPush = 0;
        int unCount = 0;
        int push = 1;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            freq[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            if (freq[i] > 0) {
                System.out.println(ch + " -> " + freq[i]);
                pq.add(new CharAndFreq(ch, freq[i]));
            }

        }
        int totalPress = 0;
        int i = 0;
        while (!pq.isEmpty()) {
            if (i < 8) {
                totalPress += pq.poll().count;
            } else if (i < 16) {
                totalPress += pq.poll().count * 2;
            } else if (i < 24) {
                totalPress += pq.poll().count * 3;
            } else {
                totalPress += pq.poll().count * 4;
            }
            i++;
        }

        return totalPress;
    }
}