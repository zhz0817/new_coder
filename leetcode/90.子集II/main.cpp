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
// 然后遍历map，
// 1只出现一次，构造出[1]，和ans里每个元素做加法加到ans里
// 因为ans里只有[]，[]+[1] = [1]
// 所以ans = [[],[1]] 
// 然后统计2。 首先构造[2],[2,2]然后加入之前ans的[[],[1]]中
// []+[2] = [2]， [1]+[2] = [1,2] ，[1]+[2,2] = [1,2,2]
