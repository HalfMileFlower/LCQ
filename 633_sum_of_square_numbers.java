class Solution {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c);
        
        while (left <= right) {
            if (left * left + right * right == c) {
                return true;
            } else if (left * left + right * right > c) {
                right--;
            } else {
                left++;
            }
        }
        
        return false;
    }
}

// Notes: two pointers - right = (int)Math.sqrt(n)
// TC: O(sqrt(n))  SC: O(1)
