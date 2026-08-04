class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int maxCandies = -1;
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }
        List<Boolean> isPossible = new ArrayList<>(Collections.nCopies(n, false));

        for (int i = 0; i < n; i++) {
            if (extraCandies + candies[i] >= maxCandies)
                isPossible.set(i , true);
            
        }
        return isPossible;
    }
}