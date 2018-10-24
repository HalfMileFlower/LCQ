class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int row = A.length;
        int column = B[0].length;
        int[][] result = new int[row][column];
        
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < A[0].length; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < column; j++) {
                        result[i][j] += A[i][k] * B[k][j];
                    }
                }
                
            }
        }
        return result;
    }
}

// Notes: three loops, but we can save some by first check if A[i][k] == 0
// TC: O(A.length * B[0].length * A[0].length) SC: O(A.length * B[0].length)
