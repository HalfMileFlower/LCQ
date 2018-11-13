class Solution {
    public int arrangeCoins(int n) {
        int layer = 1;
        
        while (layer <= n) {
            n -= layer;
            layer++;
        }
        
        return layer - 1;
    }
}

// Notes: n -= layer, layer++ loop until layer > n
// return layer - 1
// TC: O(sqrt(n))  SC: O(1)
