class Solution {
    int[] rank;
    int[] parent;

    private int find(int a) {
        if (a == parent[a])
            return a;
        return find(parent[a]);
    }

    private void union(int a, int b) {
        int par_a = find(a);
        int par_b = find(b);
        if (par_a == par_b)
            return;
        if (rank[par_a] > rank[par_b]) {
            parent[par_b] = par_a;
        } else if (rank[par_a] < rank[par_b]) {
            parent[par_a] = par_b;
        } else {
            parent[par_b] = par_a;
            rank[par_a]++;
        }
    }

    public boolean equationsPossible(String[] equations) {
        rank = new int[26];
        parent = new int[26];
        for (int i = 0; i < 26; i++)
            parent[i] = i;
        for (String str : equations) {
            char ch1 = str.charAt(0);
            char ch2 = str.charAt(3);
            if (str.charAt(1) == '=') {
                union(ch1 - 'a', ch2 - 'a');
            }
        }
        for (String str : equations) {
            char ch1 = str.charAt(0);
            char ch2 = str.charAt(3);
            if (str.charAt(1) == '!') {
                if (find(ch1 - 'a') == find(ch2 - 'a'))
                    return false;
            }
        }
        return true;
    }
}