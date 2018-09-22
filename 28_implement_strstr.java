// Notes: 
/* 
 * Rabin-Karp Algorithm:
 * Use hash function to convert a string to a integer
 * Use 31 to be the base
 * In case the result overflow, calculate the remainder with 10^6 or higher number with long int, the bigger you use as the diviser, the more strings you can demonstrate.
 * Each time you should move one character, and calculate the remainder. Keep the modularing process if any number overflows.
 * Double check if the substring really equals to the target.
 * Main idea: if the two values from a same hash function are not the same, then the origin strings must be different.
 * Key point: implementation of hash function
 */

// Brutal Solution
class Solution {
    public int strStr(String haystack, String needle) {
        int hLength = haystack.length();
        int nLength = needle.length();
        if (haystack == null || nLength > hLength) {
            return -1;
        }
        if (needle == null || nLength == 0) {
            return 0;
        }
        
        for (int i = 0; i <= hLength - nLength; i++) {
            if (haystack.substring(i, i + nLength).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}