class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        
        int[] freq = new int[26];
        char[] chars = s.toCharArray();
        
        for (Character c : chars) {
            freq[c - 'a']++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}

// Notes: two for loops, first record frequency with 26-array, second to find the first unique
// TC: O(n)  SC: O(n)（if use charAt O(26)) - n is the length of s
