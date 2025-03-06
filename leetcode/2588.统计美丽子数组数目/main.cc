class Solution {
public:
    long long beautifulSubarrays(vector<int>& nums) {
        long long ans = 0;
        int n = nums.size();
        vector<int> s(n + 1);
        for (int i = 0; i < n; ++i)
            s[i + 1] = s[i] ^ nums[i];
        unordered_map<int, int> cnt;
        for (int x : s)
            // 先计入答案再统计个数，如果反过来的话，就相当于把空子数组也计入答案了
            ans += (cnt[x]++);
        return ans;
    }
};