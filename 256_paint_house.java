class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        int houseNum = costs.length;
        int currentRow = 1;
        int[][] minCostRecord = new int[houseNum][3];
        // initialize
        for (int i = 0; i < 3; i++) {
            minCostRecord[0][i] = costs[0][i];
        }
        
        while (currentRow < houseNum) {
            for (int j = 0; j < 3; j++) {
                minCostRecord[currentRow][j] = costs[currentRow][j] + minOfColors(minCostRecord[currentRow - 1], j);
            }
            currentRow++;
        }
        
        return minOfColors(minCostRecord[currentRow - 1], -1);
    }
    
    private int minOfColors(int[] colors, int index) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < colors.length; i++) {
            if (i == index) {
                continue;
            }
            min = Math.min(min, colors[i]);
        }
        return min;
    }
}

// Notes: make a min record for each new coming house, 
// record[i][j] = min of (!record[i - 1][j]) + costs[i][j]
// TC: O(k^2 * n) k is the number of colors SC: O(kn)
