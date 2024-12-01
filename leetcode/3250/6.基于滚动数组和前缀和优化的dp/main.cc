int countOfPairs(vector<int> &nums) {
        int n = nums.size();
        int m = -1;
        int mod = pow(10,9)+7;
        for(int p:nums){
            m = max(m,p);
        }
        vector<int> cur(m+10,0);
        vector<int> before(m+10,0);
//        vector<vector<int>> dp(n+10,vector<int>(m+10,0));//dp[i][j]对于nums中
        //数组下标为i的位置作为最终位置，j是arr1中要插入的值时，dp[i][j]代表总的方案数，注意i是开区间
        for(int i=0;i<=nums[0];i++){
            before[i] = 1;
        }
        vector<int> pre(m+10);
        for(int i=1;i<n;i++){
            int sub = nums[i]-nums[i-1];
            pre[0] = before[0];
            for(int j=1;j<=nums[i-1];j++){
                pre[j] = pre[j-1]+before[j];
                pre[j] %= mod;
            }
            for(int j=0;j<=nums[i];j++){
                int index = min(j-sub,j);
                if(index>=0){
                    cur[j] += pre[min(j-sub,j)];
                    cur[j] %= mod;
                }
            }

            for(int j=0;j<before.size();j++){
                before[j] = cur[j];
                cur[j] = 0;
            }
        }
        int ans = 0;
        for(int i=0;i<=nums[n-1];i++){
            ans += before[i];//dp[n-1][i]是合法的，所以说当前位置只要满足 i>=0&&i<=nums[n-1]都是合法序列
            ans %= mod;//所以做累加和
        }
        return ans;
    }