class Solution {
public:
    int countOfPairs(vector<int> &nums) {
        int n = nums.size();
        int m = -1;
        int mod = pow(10,9)+7;
        for(int p:nums){
            m = max(m,p);
        }
        vector<vector<int>> dp(n+10,vector<int>(m+10,0));//dp[i][j]对于nums中
        //数组下标为i的位置作为最终位置，j是arr1中要插入的值时，dp[i][j]代表总的方案数，注意i是开区间
        for(int i=0;i<=nums[0];i++){
            dp[0][i] = 1;
        }
        vector<int> pre(m+10);
        for(int i=1;i<n;i++){
            int sub = nums[i]-nums[i-1];
            pre[0] = dp[i-1][0];
            for(int j=1;j<=nums[i-1];j++){
                pre[j] = pre[j-1]+dp[i-1][j];
                pre[j] %= mod;
            }
            for(int j=0;j<=nums[i];j++){
                int index = min(j-sub,j);
                if(index>=0){
                    dp[i][j] += pre[min(j-sub,j)];
                    dp[i][j] %= mod;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<=nums[n-1];i++){
            ans += dp[n-1][i];//dp[n-1][i]是合法的，所以说当前位置只要满足 i>=0&&i<=nums[n-1]都是合法序列
            ans %= mod;//所以做累加和
        }
        return ans;
    }
};