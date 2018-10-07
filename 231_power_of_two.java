// Iterative Solution: TC: O(logn) SC: O(1)
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        
        if (n == 1) {
            return true;
        }
        
        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }
}

// Recursive Solution: TC: O(logn) SC: O(1)
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n == 1) || (n % 2 == 0 && isPowerOfTwo(n / 2)));
    }
}

// Bit Operation 1: TC: O(1) SC: O(1)
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}

// Bit Operation 2: TC: O(1) SC: O(1)
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
}

// Notes: there are also other methonds: mod of pow(2, 30), table of pows, but I think they are not easy to remember.
