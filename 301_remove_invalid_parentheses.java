class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        int[] parenCount = getLeftRightParen(s);
        removeParen(s, parenCount[0], parenCount[1], result, 0);
        return result;
    }
    
    private void removeParen(String s, int leftCount, int rightCount, List<String> result, int start) {
        if (leftCount == 0 && rightCount == 0 && isValid(s)) {
            result.add(s);
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (s.charAt(i) == '(' && leftCount > 0) {
                removeParen(s.substring(0, i) + s.substring(i + 1, s.length()), leftCount - 1, rightCount, result, i);
            } else if (s.charAt(i) == ')' && rightCount > 0) {
                removeParen(s.substring(0, i) + s.substring(i + 1, s.length()), leftCount, rightCount - 1, result, i);
            }
        }
    }
    
    private boolean isValid(String s) {
        int[] count = getLeftRightParen(s);
        return count[0] == 0 && count[1] == 0;
    }
  
    private int[] getLeftRightParen(String s) {
        int[] result = new int[] {0, 0};
        for (char c : s.toCharArray()) {
            if (c == '(') {
                result[0]++;
            } else if (c == ')') {
                if (result[0] > 0) {
                    result[0]--;
                } else {
                    result[1]++;
                }
            }
        }
        return result;
    }
}

// Notes: steps as follow
// Steps:
// 1. count numbers of invalid '('s and ')'s - getLeftRightParen(String s)
// 2. check if s is valid - isValid(String s) - return true while {0, 0}
// 3. dfs - remove one parenthese and act on the remaining string
// For step 3: 
// to remove duplicate, jump over the same parentheses.
// a pointer "start" is needed to remove the parentheses from left to right
// TC: O(n * 2 ^ n) - worst case (a(a(a(a)....))) while #"(a" == 2n, #")" = n, it will be picking n "(" from 2n to remove 
// (n is the count of valid left and right parentheses)
// SC: O(n)
