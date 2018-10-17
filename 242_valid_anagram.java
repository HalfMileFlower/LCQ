class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] sChars = new int[26];
        int[] tChars = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            sChars[s.charAt(i) - 'a']++;
            tChars[t.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }
        return true;
    }
}

// Notes: use two arrays (length == 26) to store chars of strings s and t
// compare each char freq
// TC: O(n) SC: O(n) n is the length of s/t
// Follow up: unicode: open an array (length == 65536), array index = (int)s.charAt(i)
