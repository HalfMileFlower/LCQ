class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        
        int prev = 1;
        int curr = 2;
        
        for (int i = 3; i <= n; i++) {
            curr = curr + prev;
            prev = curr - prev;
        }
        return curr;
    }
}

// Notes: dp : f[n] = f[n - 1] + f[n - 2]
// TC: O(n)  SC: O(1)
