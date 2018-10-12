// HashMap Solution
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        
        Map<Character, Character> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (charMap.containsKey(sChar)) {
                if (charMap.get(sChar) != tChar) {
                    return false;
                } 
            } else {
                if (charMap.containsValue(tChar)) {
                    return false;
                } else {
                    charMap.put(sChar, tChar);
                }
            }
        }
        return true;
    }
}

// Notes: (sChar -> tChar) mapping, remember that if sChar doesn't exists, check if tChar exists first
// TC: O(n) SC: O(n)

// Array Solution
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        
        int[] indicesOfChars = new int[512];
        for (int i = 0; i < s.length(); i++) {
            if (indicesOfChars[s.charAt(i)] != indicesOfChars[t.charAt(i) + 256]) {
                return false;
            } else {
                indicesOfChars[s.charAt(i)] = i + 1;
                indicesOfChars[t.charAt(i) + 256] = i + 1;
            }
        }
        return true;
        
    }
}

// Notes: char can be taken as integer, update last time we meet the char with index + 1
// "index + 1" reason: not 0, so will not be mistaken with initialized 0s
// TC: O(n) SC: O(n)
