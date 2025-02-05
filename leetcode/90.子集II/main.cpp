class Solution {
   public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> ans;
        ans.emplace_back();  // 加一个空数组
        unordered_map<int, int> map1;
        for (int num : nums) {
            map1[num]++;
        }
        for (auto& iter : map1) {
            int length = ans.size();
            int key = iter.first;
            int value = iter.second;
            vector<vector<int>> tmp;
            for (int i = 1; i <= value; i++) {
                vector<int> arr(i, key);
                tmp.push_back(arr);
            }
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < tmp.size(); j++) {
                    vector<int> next(ans[i].begin(),
                                     ans[i].end());  // 重新构造，相当于深拷贝
                    next.insert(next.end(), tmp[j].begin(), tmp[j].end());
                    ans.push_back(next);
                }
            }
        }
        return ans;
    }
};
// 模拟一下过程，比如nums = [1,2,2]
// 那么 ans = [[]],首先构造一个空数组进去
// 然后构建map做计数器,map[1] = 1 map[2] = 2,
// 然后遍历map，ans = [[],[1]] ，按照计数器中的个数构建子数组。
//  然后统计2。 首先构造[2],[2,2]然后把之间的[[],[1]]加进去
//  []+[2] = [2] [1]+[2] = [1,2] [1]+[2,2] = [1,2,2]
//  这样能保证构造出来的不重复