class Solution {
public:
  int dfs(int index, vector<int> &arr1, vector<int> &nums) {
    int ans = 0;
    if (arr1.size() == nums.size()) {
      return 1;
    }
    for (int i = 0; i <= nums[index]; i++) {
      int length = arr1.size();
      int value1 = i;
      int value2 = nums[index] - i;
      int pre1 = length == 0 ? -1 : arr1[length - 1];
      int pre2 = length == 0 ? INT32_MAX : nums[length - 1] - arr1[length - 1];
      if (value1 >= pre1 && pre2 >= value2) {
        arr1.push_back(value1);
        ans += dfs(index + 1, arr1, nums);
        arr1.pop_back();
      }
    }
    return ans;
  }
  int countOfPairs(vector<int> &nums) {
    vector<int> arr1;
    return dfs(0, arr1, nums);
  }
};