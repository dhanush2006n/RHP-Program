class Solution {
    private final int[][] diff = {
        {-1, -1}, {-1, 0}, {-1, 1},
        { 0, -1},          { 0, 1},
        { 1, -1}, { 1, 0}, { 1, 1}
    };

    public int numIslands8Way(char[][] grid) {
       if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int r = grid.length;
        int c = grid[0].length;
        int islands = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(grid, r, c, i, j);
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int r, int c, int i, int j) {
        
        grid[i][j] = '0';
        for (int w = 0; w < 8; w++) {
            int ar = i + diff[w][0];
            int ac = j + diff[w][1];
            if (ar >= 0 && ar < r && ac >= 0 && ac < c && grid[ar][ac] == '1') {
                dfs(grid, r, c, ar, ac);
            }
        }
    }
}
