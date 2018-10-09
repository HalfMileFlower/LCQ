class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        if (s.length() % 2 != 0) {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (!stack.empty() && stack.pop() != c) {
                return false;
            }
        }
        
        return stack.empty();
    }
}

// Notes: push opposite, pop to check if same. return empty or not
// TC: O(n) SC: O(n)
