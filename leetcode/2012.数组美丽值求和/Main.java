class Solution {
    public int[] getMax(int[] nums) { //维护前缀最大数组
        int[] res = new int[nums.length];
        int max = nums[0];
        res[0] = max;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
            res[i] = max;
        }
        return res;
    }
    public int[] getMin(int[] nums) { //维护后缀最小数组
        int[] res = new int[nums.length];
        int min = nums[nums.length - 1];
        res[nums.length - 1] = min;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < min)
                min = nums[i];
            res[i] = min;
        }
        return res;
    }
    public int sumOfBeauties(int[] nums) {
        // 2 对于所有 0 <= j < i 且 i < k <= nums.length - 1 ，满足 nums[j] < nums[i] < nums[k]
        // 1，如果满足 nums[i - 1] < nums[i] < nums[i + 1] ，且不满足前面的条件
        // 0，如果上述条件全部不满足
        // 如果想要加2分，需要保证当前nums[i]比左侧所有的数都大，并且比右侧的所有数都小
        // 等价于需要保证当前nums[i]比左侧最大的数大，并且比右侧最小的值小
        // 因此维护一个前缀和后缀数组
        // 前缀数组max，max[i]是i左侧nums中最大的数，包括下标i。
        // 后缀数组min，min[i]是i右侧nums中最小的数，包括下标i。
        int length = nums.length;
        int count = 0;
        int[] max = getMax(nums);
        int[] min = getMin(nums);
        for (int i = 1; i < length - 1; i++) {
            if (nums[i] > max[i - 1] && nums[i] < min[i + 1]) //加2分
                count += 2;
            else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) //加1分
                count++;
        }
        return count;
    }
}