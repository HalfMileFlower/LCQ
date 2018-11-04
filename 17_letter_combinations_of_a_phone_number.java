// Recursive Solution
class Solution {
    private static final Map<Character, String[]> digitToString = createMap();
    
    private static Map<Character, String[]> createMap() {
        Map<Character, String[]> map = new HashMap<>();
        map.put('2', new String[] {"a", "b", "c"});
        map.put('3', new String[] {"d", "e", "f"});
        map.put('4', new String[] {"g", "h", "i"});
        map.put('5', new String[] {"j", "k", "l"});
        map.put('6', new String[] {"m", "n", "o"});
        map.put('7', new String[] {"p", "q", "r", "s"});
        map.put('8', new String[] {"t", "u", "v"});
        map.put('9', new String[] {"w", "x", "y", "z"});
        
        return map;
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        String emptyStart = "";
        findCombinations(0, digits.length() - 1, digits, result, emptyStart);
        return result;
    }
    
    private void findCombinations(int left, int right, String digits, List<String> result, String start) {
        if (left > right) {
            result.add(start);
            return;
        }
        
        String[] chars = digitToString.get(digits.charAt(left));
        String temp = start;
        for (int j = 0; j < chars.length; j++) {
            start += chars[j];
            findCombinations(left + 1, right, digits, result, start);
            start = temp;
        }
    }
}

// Notes: backtracking 
// TC: O(4^n) SC: O(n) - recursive stack
