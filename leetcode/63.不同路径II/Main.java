class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1)
            return 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = -1;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (obstacleGrid[m - 1][i] != -1)
                obstacleGrid[m - 1][i] = 1;
            else
                break;
        }
        for (int i = m - 1; i >= 0; i--) {
            if (obstacleGrid[i][n - 1] != -1)
                obstacleGrid[i][n - 1] = 1;
            else
                break;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == -1)
                    continue;
                int temp1 =
                    (obstacleGrid[i + 1][j] == -1) ? 0 : obstacleGrid[i + 1][j];
                int temp2 =
                    (obstacleGrid[i][j + 1] == -1) ? 0 : obstacleGrid[i][j + 1];
                obstacleGrid[i][j] = temp1 + temp2;
            }
        }
        return obstacleGrid[0][0];
    }
}