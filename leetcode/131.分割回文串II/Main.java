class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] flag = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(flag[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++)
                flag[i][j] =
                    (s.charAt(i) == s.charAt(j)) && (flag[i + 1][j - 1]);
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = -1; // 最重要的边界，由dp[i] + 1反推导出来
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (flag[i - 1][j - 1]) {
                    dp[j] = Math.min(dp[j],
                        dp[i - 1]
                            + 1); // i在当前区间是闭区间，在前一个转移过来的区间是开区间，所以是dp[i-1]转移来的
                }
            }
        }
        return dp[n];
    }
}