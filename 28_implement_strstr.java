// Brutal Solution
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            for (int k = 0; k < needle.length(); k++) {
                if (needle.charAt(k) != haystack.charAt(i + j)) {
                    break;
                }
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}

// Notes: TC: O(m * n) SC: O(1)

// Rabin-Karp