class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        
        // store char freq of t
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Integer count = map.get(t.charAt(i));
            if (count == null) {
                map.put(t.charAt(i), 1);
            } else {
                map.put(t.charAt(i), 1 + count);
            }
        }
        
        // sliding window
        int matchCount = 0;
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        for (int fast = 0, slow = 0; fast < s.length(); fast++) {
            char end = s.charAt(fast);
            if (map.containsKey(end)) {
                Integer freq = map.get(end);
                map.put(end, freq - 1);
                if (freq == 1) {
                    matchCount++;
                }
            }
            
            while (matchCount == map.size()) {
                if (fast - slow + 1 < min) {
                    min = fast - slow + 1;
                    left = slow;
                    right = fast;
                }
                 
                char begin = s.charAt(slow);
                if (!map.containsKey(begin)) {
                    slow++;
                } else {
                    slow++;
                    Integer beginCount = map.get(begin);
                    map.put(begin, beginCount + 1);
                    if (beginCount == 0) {
                        matchCount--;
                    }
                }
            }
            
        }
        
        return min == Integer.MAX_VALUE ? "" : s.substring(left, right + 1);
    }
}

// Notes: sliding window
// use a hash map to store characters in t and their frequency
// use fast and slow pointer to cut a substring
// use machCount to store how many chars have been matched
// fast in map -> its freq--, if freq == 1, 1->0 matchCount++
// if matchCount == map.size, a valid substring is found, move slow to see if the substring can be shorter
// if slow in map && its freq == 0 -> its freq++ since we remove a required char, matchCount--
// remember to check if min is still Integer.MAX_VALUE to determine if a valid substring is found
// TC: O(n)  SC: O(1)
