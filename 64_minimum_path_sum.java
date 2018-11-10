class Solution {
    public int minPathSum(int[][] grid) {
        // min(x, y) = min((x - 1, y) + (x, y), (x, y - 1) + (x, y))
        
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;
        if (cols == 0) {
            return 0;
        }
        
        int[][] sum = new int[rows][cols];
        sum[0][0] = grid[0][0];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int left = inBound(i, j - 1, rows, cols) ? sum[i][j - 1] : Integer.MAX_VALUE;
                int up = inBound(i - 1, j, rows, cols) ? sum[i - 1][j] : Integer.MAX_VALUE;
                sum[i][j] = grid[i][j] + Math.min(left, up);
            }
        }
        return sum[rows - 1][cols - 1];
    }
    
    private boolean inBound(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}

// Notes: DP
// min(x, y) = min((x - 1, y) + (x, y), (x, y - 1) + (x, y))
// remember to check in bound
// TC: O(m * n)  SC: O(m * n)
