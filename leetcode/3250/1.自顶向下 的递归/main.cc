class Solution {
public:
    int ans = 0;

    void dfs(int index,vector<int>& arr1,vector<int>& nums){
        if(arr1.size()==nums.size()){
            ans++;
            return;
        }
        for(int i=0;i<=nums[index];i++){
            int length = arr1.size();
            int value1 = i;
            int value2 = nums[index]-i;
            int pre1 = length == 0?-1:arr1[length-1];
            int pre2 = length == 0?INT32_MAX:nums[length-1]-arr1[length-1];
            if(value1>=pre1&&pre2>=value2){
                arr1.push_back(value1);
                dfs(index+1,arr1,nums);
                arr1.pop_back();
            }
        }
    }
    int countOfPairs(vector<int>& nums) {
        vector<int> arr1;
        dfs(0,arr1,nums);
        return this->ans;
    }
};