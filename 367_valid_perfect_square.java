class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;
        
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (right * right == num) {
            return true;
        }
        
        if (left * left == num) {
            return true;
        }
        
        return false;
    }
}

// Notes: binary search
// remember long left & long right & long mid!!
// TC: O(logn)  SC: O(1)
