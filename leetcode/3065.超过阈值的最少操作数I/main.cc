class Solution {
public:
    int binarySearch(vector<int>& nums,int target){
        int left = 0;
        int right = nums.size()-1;
        int ans = -1;
        if(nums[left]>=target){
            return 0;
        }
        if(nums[right]<target){
            return nums.size();
        }
        int mid;
        while(left<=right){
            mid = left+(right-left)/2;
            if(nums[mid]>=target){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
    int minOperations(vector<int>& nums, int k) {
        sort(nums.begin(),nums.end());
        return binarySearch(nums,k);
    }
};