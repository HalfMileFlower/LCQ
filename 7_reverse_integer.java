class Solution {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = x % 10 + res * 10;
            x = x / 10;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)res;
    }
}

// Notes: Remember to consider if the result is overflow!