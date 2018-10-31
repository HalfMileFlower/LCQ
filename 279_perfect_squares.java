// DP solution
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
            }
        }
        
        return dp[n];
    }
}

// Notes: dp - initialize dp[] with Integer.MAX_VALUE
// dp[square] = 1
// dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j])
// result is dp[n]
// TC: O(sqrt(n))  SC: O(n)
