class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> ld = new LinkedList<>();
        boolean[][] landChecker = new boolean[land.length][land[0].length];

        for(int i=0; i<land.length; i++) {
            for(int j=0; j<land[0].length; j++) {
                if(!landChecker[i][j] && land[i][j] == 1) {
                    int[] in = {i,j,0,0};
                    for(int r=i; r<land.length; r++) {
                        for(int c=j; c<land[0].length; c++) {
                            if(land[r][c] == 1) {
                                if(in[2] < r) in[2] = r;
                                if(in[3] < c) in[3] = c;
                                landChecker[r][c] = true;
                            } else {
                                break;
                            }
                        }
                        if(land[r][in[3]]==0) break;
                    }
                    ld.add(in);
                }
            }
        }

        return ld.toArray(new int[ld.size()][]);
    }
}