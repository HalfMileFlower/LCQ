/* Notes
 * Enumeration Method: To solve the odd and even length problem, we can loop with two pointers, i for the left center, i + 1 for the right center.
 * 
 * 
 * Follow up: Enumeration for center is not allowed. ---- Dynamic Programming
 * 
 */


 // Enumeration Method:
 class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (s == null || len == 0) {
            return "";
        }
        
        int maxLength = 0;
        int newLength = 0;
        int start = 0; 
        for (int i = 0; i < len; i++) {
            newLength = findPalindrome(s, i, i + 1);
            if (newLength > maxLength) {
                maxLength = newLength;
                start = i - maxLength / 2 + 1;
            }
            
            newLength = findPalindrome(s, i, i);;
            if (newLength > maxLength) {
                maxLength = newLength;
                start = i - maxLength / 2;
            }
        }
        
        return s.substring(start, start + maxLength);
    }
    
    private int findPalindrome(String s, int left, int right) {
        int res = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            if (left == right) {
                    res++;
                } else {
                    res += 2;
                }
            left--;
            right++;
        }
        return res;
    }
}


// Dynamic Programming Method:
class Solution {
    public String longestPalindrome(String s) {
        
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
        int start = 0;
        int longest = 1;
        
        for (int i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
        }
        
        for (int i = 0; i < len - 1; i++) {
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (isPalindrome[i][i + 1]) {
                start = i;
                longest = 2;
            }
        }
        
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (isPalindrome[i][j] && j - i + 1> longest) {
                    start = i;
                    longest = j - i + 1;
                }
            }
        }
        
        return s.substring(start, start + longest);
    }
}

