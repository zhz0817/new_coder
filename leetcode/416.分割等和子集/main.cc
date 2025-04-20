class Solution {
   public:
    bool canPartition(vector<int>& nums) {
        int sum = 0;
        for (int m : nums) {
            sum += m;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int n = nums.size();
        vector<vector<int>> dp(n + 1, vector<int>(sum / 2 + 1, 0));
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum / 2; j++) {  // j表示背包的容量
                if (j >= nums[i - 1]) {
                    dp[i][j] = max(nums[i - 1] + dp[i - 1][j - nums[i - 1]],
                                   dp[i - 1][j]);
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j]);
                }
            }
        }
        return dp[n][sum / 2] == sum / 2;
    }
};