class Solution {
   public:
    unordered_set<string> set1;
    vector<vector<int>> ans;
    void dfs(vector<int>& nums, vector<int>& tmp, vector<int>& isVisited) {
        if (tmp.size() == nums.size()) {
            string s;
            for (int i = 0; i < tmp.size(); i++) {
                s += to_string(tmp[i]);
                s += "-";
            }
            if (set1.find(s) == set1.end()) {
                ans.emplace_back(tmp.begin(), tmp.end());
                set1.insert(s);
            }
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = 1;
                tmp.push_back(nums[i]);
                dfs(nums, tmp, isVisited);
                tmp.pop_back();
                isVisited[i] = 0;
            }
        }
    }
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        int n = nums.size();
        vector<int> isVisited(n, 0);
        vector<int> tmp;
        for (int i = 0; i < n; i++) {
            isVisited[i] = 1;
            tmp.push_back(nums[i]);
            dfs(nums, tmp, isVisited);
            tmp.pop_back();
            isVisited[i] = 0;
        }
        return ans;
    }
};