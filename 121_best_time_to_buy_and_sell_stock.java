class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int buy = 0;
        int sell = 1;
        int max = Integer.MIN_VALUE;
        
        while (sell < prices.length) {
            max = Math.max(max, prices[sell] - prices[buy]);
            if (prices[sell] < prices[buy]) {
                buy = sell;
            }
            sell++;
        }
        return max < 0 ? 0 : max;
    }
}

// Notes: Remember this condition: the price keeps decreasing -- cannot return negative values!