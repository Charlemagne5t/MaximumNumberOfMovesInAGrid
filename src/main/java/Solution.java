class Solution {
    public int maxMoves(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        
        for(int i = 0; i < grid.length; i++) {
            res = Math.max(res, dfs(grid, i, 0, 0, -1, vis));
        }        

        return res;
    }

    int dfs(int[][] grid, int i, int j, int moves, int prev,int[][] vis) {
        int m = grid.length;
        int n = grid[0].length;
        
        if(i < 0 || i == m || j == n || grid[i][j] <= prev) {
            return moves - 1;
        }
        if(vis[i][j] != 0) {
            return vis[i][j];
        }
        int res = 0;
        int[][] dest = {{-1, 1}, {0,  1}, {1, 1}};
        for(int[] d : dest) {
            res = Math.max(res, dfs( grid, i + d[0], j + d[1], moves + 1, grid[i][j], vis));
        }
        vis[i][j] = res;
        return res;
    }
}
