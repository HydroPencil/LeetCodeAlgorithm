class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                ans += perimeterCheck(grid, i, j);
            }
        }
        return ans;
    }
    public int perimeterCheck(int[][] grid, int r, int c) {
        int ans = 0;
        if(grid[r][c] == 1) {
            ans += upCheck(grid, r, c);
            ans += downCheck(grid, r, c);
            ans += leftCheck(grid, r, c);
            ans += rightCheck(grid, r, c);
        }
        return ans;
    }
    private int upCheck(int[][] grid, int r, int c) {
        if(r == 0) {
            return 1;
        } else {
            if(grid[r-1][c] == 0) return 1;
        }
        return 0;
    }
    private int downCheck(int[][] grid, int r, int c) {
        if(r == grid.length-1) {
            return 1;
        } else {
            if(grid[r+1][c] == 0) return 1;
        }
        return 0;
    }
    private int leftCheck(int[][] grid, int r, int c) {
        if(c == 0) {
            return 1;
        } else {
            if(grid[r][c-1] == 0) return 1;
        }
        return 0;
    }
    private int rightCheck(int[][] grid, int r, int c) {
        if(c == grid[0].length-1) {
            return 1;
        } else {
            if(grid[r][c+1] == 0) return 1;
        }
        return 0;
    }
}