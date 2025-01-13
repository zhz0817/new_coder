class Solution {
public:
    int waysToSplitArray(vector<int>& nums) {
        long long sum = 0;
        for(int n:nums){
            sum+=n;
        }
        int ans = 0;
        int n = nums.size();
        long long left = 0;
        for(int i=0;i<n-1;i++){
            left+=nums[i];
            if(left>=sum-left){
                ans++;
            }
        }
        return ans;
    }
};