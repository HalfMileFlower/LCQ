class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        
        if (target >= letters[end]) {
            return letters[start];
        }
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (letters[start] > target) {
            return letters[start];
        }
        return letters[end];
    }
}

// Notes: char can be ordered directly by >, = , <
// pay attention to the "wrap around" condition, if target > letter[end], return letter[start]
// TC: O(logn) SC: O(1)
