class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int num = 0;
        int curr = s.length() - 1;
        int next = s.length() - 1;
        while (curr >= 0) {
            int currVal = map.get(s.charAt(curr));
            int nextVal = map.get(s.charAt(next));
            if (currVal >= nextVal) {
                num +=currVal;
                next = curr;
                curr--;
                
            } else {
                num -= currVal;
                curr--;
                next = curr;
            }
            System.out.println(num);
        }
        return num;
    }
}