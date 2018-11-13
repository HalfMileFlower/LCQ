class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int buy = 0;
        int profit = 0;
        int sell = 1;
        
        while (sell < prices.length) {
            if (prices[sell] >= prices[sell - 1]) {
                sell++;
                continue;
            }
            
            profit += prices[sell - 1] - prices[buy];
            buy = sell;
            sell++;
        }
        
        if (prices[sell - 1] > prices[buy]) {
            profit += prices[sell - 1] - prices[buy];
        }
        
        return profit;
    }
}

// Notes: two pointers buy and sell
// while sell < prices.length, if sell[i - 1] < sell[i] sell++ - keep stock
// if not profit += prices[sell - 1] - prices[buy] - sell stock if before a drop
// remember to add the last increase if there is one
// TC: O(n)  SC: O(1)
