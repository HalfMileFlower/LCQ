class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        char[] chars = s.toCharArray();
        int[] freqs = new int[256];
        for (char c : chars) {
            freqs[c]++;
        }
        
        for (int freq : freqs) {
            res += freq / 2 * 2;
        }
        
        if (res != s.length()) {
            res++;
        }
        return res;
    }
}