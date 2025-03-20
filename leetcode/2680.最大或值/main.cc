class Solution {
   public:
    long long maximumOr(vector<int>& nums, int k) {
        int n = nums.size();
        vector<long long> pre(n), tail(n);
        // pre[i]是0到i左闭右闭的前缀或和，tail[i]是i到n-1左闭右闭的后缀或和
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                pre[i] = nums[i];
                tail[n - i - 1] = nums[n - i - 1];
            } else {
                pre[i] = nums[i] | pre[i - 1];
                tail[n - i - 1] = nums[n - i - 1] | tail[n - i];
            }
        }
        long long ans = 0;
        for (int i = 0; i < n; i++) {  // 当前i位置乘2
            long long front = i == 0 ? 0 : pre[i - 1];
            long long end = i == n - 1 ? 0 : tail[i + 1];
            long long tmp = nums[i];
            int m = k;
            while (m--) {
                tmp *= 2;  // 贪心算法
            }
            ans = max(ans, front | tmp | end);
        }
        return ans;
    }
};