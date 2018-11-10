// DP Solution
class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        int[][] moves = {{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}};
        double[][] prev = new double[N][N];
        prev[r][c] = 1.0;
        
        for (int i = 0; i < K; i++) {
            double[][] curr = new double[N][N];
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    for (int j = 0; j < 8; j++) {
                        int row = x + moves[j][0];
                        int col = y + moves[j][1];
                        if (isOnBoard(row, col, N)) {
                            curr[row][col] += prev[x][y];
                        }
                    }
                }
            }
            prev = curr;
        }
        
        double total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                total += prev[i][j];
            }
        }
        return total / Math.pow(8, K);
    }
    
    private boolean isOnBoard(int row, int col, int N) {
        return row >= 0 && row < N && col >= 0 && col < N;
    }
}

// Notes: calculate time of reaches for each position, add them together and divided by pow(8, K)
// use double to initialize the array, one prev and one curr
// TC: O(k * N^2)  SC: O(N ^ 2)
