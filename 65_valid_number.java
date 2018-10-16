class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        s = s.trim();
        boolean numberFound = false;
        boolean pointFound = false;
        boolean numberAfterE = true;
        boolean eFound = false;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numberFound = true;
                if (!numberAfterE) {
                    numberAfterE = true;
                }
            } else if (s.charAt(i) == '.') {
                if (eFound || pointFound) {
                    return false;
                }
                pointFound = true;
            } else if (s.charAt(i) == 'e') {
                if (eFound || !numberFound) {
                    return false;
                }
                numberAfterE = false;
                eFound = true;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numberFound && numberAfterE;
    }
}

// Notes: trim first, then numberFound, pointFound, eFound, numberAfterE
// Rules
/* numberFound must be true
 * if 'e' found, update numberAfterE to false
 * 'e' and point must not be found twice, point must not be after 'e'
 * '+' and '-' can only be the first char or the next one of 'e'
 * other characters => false
 */
// return numberFound && numberAfterE
// TC: O(n) SC: O(1)
