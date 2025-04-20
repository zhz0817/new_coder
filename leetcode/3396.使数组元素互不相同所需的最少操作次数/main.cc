class Solution {
    public:
        int minimumOperations(vector<int>& nums) {
            unordered_map<int,int> map1;
            for (int&num : nums) {
                map1[num]++;
            }
            int len = nums.size();
            int ans = 0;
            int index = 0;
            while (len - index > map1.size()) {
                for (int i=0;i<3&&index<len;i++) {
                    int value = nums[index];
                    map1[value]--;
                    index++;
                    if (map1[value]==0) {
                        map1.erase(value);
                    }
                }
                ans++;
            }
            return ans;
        }
    };