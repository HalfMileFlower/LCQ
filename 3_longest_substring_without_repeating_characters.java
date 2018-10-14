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

// HashSet Solution
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } 
        
        int max = Integer.MIN_VALUE;
        int longestStart = 0;
        
        Set<Character> set = new HashSet<>();
        int pointer = 0;
        while (pointer < s.length()) {
            if (set.contains(s.charAt(pointer))) {
                set.remove(s.charAt(longestStart));
                longestStart++;
            } else {
                set.add(s.charAt(pointer));
                pointer++;
                max = Math.max(max, set.size());
            }
        }
        return max;
    }
}

// Notes: use hashset to record unique characters in the result string
// if a character is not in set, put it in; else remove from head until the repeated character is removed
// calculate the max of set size
// TC: O(n) SC: O(n)
