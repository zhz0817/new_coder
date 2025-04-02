class Solution {
    public:
        long long maximumTripletValue(vector<int>& nums) {
            long long ans = 0;
            int n = nums.size();
            vector<int> tail_max(n+1,0);
            for(int i=n-1;i>1;i--){
                tail_max[i] = max(tail_max[i+1],nums[i]);
            }
            int pre_max = nums[0];
            for(int i=1;i<n-1;i++){
                long long value = (long long)(pre_max-nums[i])*tail_max[i+1];
                ans = max(ans,value);
                pre_max = max(pre_max,nums[i]);
            }
            return ans;
        }
    };