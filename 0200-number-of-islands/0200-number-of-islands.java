class Solution {
    private boolean[][] gridCheck;
    private char[][] gridCopy;
    private int landCount;
    class Coordinate {
        int r;
        int c;
        Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int numIslands(char[][] grid) {
        landCount = 0;
        gridCopy = grid;
        gridCheck = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(gridCheck[i][j] == false && grid[i][j] == '1') {
                    landCheck(i, j);
                }
            }
        }
        return landCount;
    }
    private void landCheck(int r, int c) {
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(r,c));
        while(!q.isEmpty()){
            Coordinate now = q.remove();
            if(gridCheck[now.r][now.c] == true) continue;
            
            gridCheck[now.r][now.c] = true;
            if(now.r > 0 && gridCopy[now.r-1][now.c] == '1') {
                q.add(new Coordinate(now.r-1, now.c));
            }
            if(now.c > 0 && gridCopy[now.r][now.c-1] == '1') {
                q.add(new Coordinate(now.r, now.c-1));
            }
            if(now.r < gridCheck.length-1 && gridCopy[now.r+1][now.c] == '1') {
                q.add(new Coordinate(now.r+1, now.c));
            }
            if(now.c < gridCheck[0].length-1 && gridCopy[now.r][now.c+1] == '1') {
                q.add(new Coordinate(now.r, now.c+1));
            }
        }
        landCount++;
    }
}