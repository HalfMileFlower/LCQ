// BFS Solution
class Coordinate {
    int x;
    int y;
    
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    searchIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void searchIsland(char[][] grid, int x, int y) {
        int[] xChange = {0, 1, 0, -1};
        int[] yChange = {1, 0, -1, 0};
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        
        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int neighborX = current.x + xChange[i];
                int neighborY = current.y + yChange[i];
                if (!inBound(grid, neighborX, neighborY)) {
                    continue;
                }
                if (grid[neighborX][neighborY] == '1') {
                    grid[neighborX][neighborY] = '0';
                    queue.offer(new Coordinate(neighborX, neighborY));
                }
            }
        }
    }
    
    private boolean inBound(char[][] grid, int x, int y) {
        int rows = grid.length;
        int columns = grid[0].length;
        
        return (x < rows && x >= 0) && (y < columns && y >= 0);
    }
}

// Notes: for a '1', find connected '1's and set them to '0' after checking
// class Coordination
// change directions: int[] xChange = {0, 1, 0, -1}; int[] yChange = {1, 0, -1, 0};
// function inBound()
// TC: O(r * c) SC: O(r * c)
