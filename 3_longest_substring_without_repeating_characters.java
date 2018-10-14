// HashMap Solution

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } 
        
        int max = Integer.MIN_VALUE;
        int longestStart = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                longestStart = Math.max(longestStart, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - longestStart + 1);
        }
        return max;
    }
}

// Notes: use a hashmap to store the character and its index, two pointers for longest result
// Each time we meet a repeating character, move the slow one(tracking the head of non-repeating string)
// TC: O(n) SC: O(n)

