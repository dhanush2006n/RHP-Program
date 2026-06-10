class Solution {
    final int diff[][] = {{0,-1},{0,1},{-1,0},{1,0}};

    private int dfs(int[][] matrix, int[][] dp, int R, int C, int row, int col) {
       
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int adjm = 0;
        for (int i = 0; i < 4; i++) {
            int ar = row + diff[i][0];
            int ac = col + diff[i][1];

    
            if (ar >= 0 && ar < R && ac >= 0 && ac < C && matrix[ar][ac] > matrix[row][col]) {
                adjm = Math.max(adjm, dfs(matrix, dp, R, C, ar, ac));
            }
        }

       
        dp[row][col] = adjm + 1;
        return dp[row][col];
    }
