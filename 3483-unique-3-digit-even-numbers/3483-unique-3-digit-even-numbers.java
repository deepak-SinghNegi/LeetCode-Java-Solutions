class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] visited;

    public int totalNumbers(int[] digits) {
        visited = new boolean[digits.length];
        helper(digits, 0, 0);
        int count = 0;
        for (int x : set) {
            if (x % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private void helper(int[] digits, int number, int size) {
        if (size == 3) {
            set.add(number);
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            if (visited[i])
                continue;
            if (size == 0 && digits[i] == 0)
                continue;
            visited[i] = true;
            helper(digits, number * 10 + digits[i], size + 1);
            visited[i] = false;
        }
    }
}