class Solution {
   public:
    bool search(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[right] == nums[mid]) {
                right--;
                continue;
            }
            if (nums[mid] < nums[right]) {  // mid到right一定是单调增的
                if (nums[right] >= target && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target &&
                    nums[mid] >
                        target) {  // 一定是nums[left]去比较，用nums[right]比较无法确定左右区间
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
};