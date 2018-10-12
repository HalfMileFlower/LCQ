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

