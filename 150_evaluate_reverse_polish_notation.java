class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (!isOperation(token)) {
                stack.push(token);
            } else {
                String secondInteger = stack.pop();
                String firstInteger = stack.pop();
                int result = calculate(token, firstInteger, secondInteger);
                stack.push("" + result);
            }
        }
        return Integer.parseInt(stack.pop());
    }
    
    private boolean isOperation(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        }
        return false;
    }
    
    private int calculate(String operator, String first, String second) {
        int firstInteger = Integer.parseInt(first);
        int secondInteger = Integer.parseInt(second);
        switch (operator) {
            case "+":
                return firstInteger + secondInteger;
            case "-":
                return firstInteger - secondInteger;
            case "*":
                return firstInteger * secondInteger;
            case "/":
                return firstInteger / secondInteger;
        }
        return -1;
    }
}

// Notes: use stack to store numbers, each time meet a operator, calculate and push result back
// pay attention to the transformation from string to integer
// TC: O(n) SC: O(n)
