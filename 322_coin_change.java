// Initialization Solution
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        
        if (amount == 0) {
            return 0;
        }
        
        int[] steps = new int[amount + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                steps[coins[i]] = 1;
            }
            min = Math.min(min, coins[i]);
        }
        
        for (int j = min; j <= amount; j++) {
            if (steps[j] == 1) {
                continue;
            }
            int value = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] > j) {
                    continue;
                }
                if (steps[j - coins[i]] == 0) {
                    continue;
                }
                value = Math.min(value, steps[j - coins[i]]);
            }
            steps[j] = value == Integer.MAX_VALUE ? 0 : value + 1;
        }
        
        return steps[amount] == 0 ? -1 : steps[amount];
    }
}

// Notes: DP - for each amount find the least amount by loop through coins, min[i] = min(min[i - coins[j]])
// TC: O(amount * #coins)  SC: O(amount)


// Shorter Solution based on same idea
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        
        if (amount == 0) {
            return 0;
        }
        
        int[] steps = new int[amount + 1];
        
        for (int j = 1; j <= amount; j++) {
            steps[j] = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] <= j && steps[j - coins[i]] != Integer.MAX_VALUE) {
                    steps[j] = Math.min(steps[j - coins[i]] + 1, steps[j]);
                }
            }
        }
        
        return steps[amount] == Integer.MAX_VALUE ? -1 : steps[amount];
    }
}

// Notes: directly update the steps of existing coins
// TC & SC are same as above
