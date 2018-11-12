// Two Binary Search Solution
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        if (target < matrix[0][0] || target > matrix[rows][cols]) {
            return false;
        }
        
        int foundRow = findRow(matrix, 0, rows, target);
        if (matrix[foundRow][0] == target) {
            return true;
        } 
        
        int left = 0;
        int right = cols;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (matrix[foundRow][mid] == target) {
                return true;
            } else if (matrix[foundRow][mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (matrix[foundRow][right] == target || matrix[foundRow][left] == target) {
            return true;
        }
        return false;
    }
    
    private int findRow(int[][] matrix, int up, int down, int target) {
        while (up + 1 < down) {
            int mid = up + (down - up) / 2;
            if (matrix[mid][0] == target) {
                return mid;
            } else if (matrix[mid][0] < target) {
                up = mid;
            } else {
                down = mid;
            }           
        }
        
        if (matrix[down][0] <= target) {
            return down;
        }
        return up;
    }
}

// Notes: two binary searches - first find row then find in this row
// TC: O(log(mn))  SC: O(1)

// One Binary Search Solution
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) {
            return false;
        }
        
        int left = 0;
        int right = rows * cols - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            } else if (matrix[mid / cols][mid % cols] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}

// Notes: each point can be represented as x = cols * #row + y
// so matrix[mid / cols][mid % cols] compare with target
// the implementation of binary search in this method is different from others
// TC: O(log(mn))  SC: O(1)
