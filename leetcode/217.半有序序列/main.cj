import std.collection.*

class Solution {
    func max(a: Int64, b: Int64) {
        if (a > b) {
            return a;
        }
        return b;
    }

    func min(a: Int64, b: Int64) {
        if (a < b) {
            return a;
        }
        return b;
    }

    func semiOrderedPermutation(nums: Array<Int64>): Int64 {
        var ans: Int64 = 0;
        var index: Int64 = -1;
        var min = 0x3f3f3f3f; //变量用var,0x3f3f3f3f是一个很大的数
        let n = nums.size; //常量用let
        for (i in 0..n) {
            if (min > nums[i]) {
                index = i
                min = nums[i]
            }
        }
        while (index > 0) {
            let t = nums[index]; //语言自动做了类型推断，不用写类型
            nums[index] = nums[index - 1]
            nums[index - 1] = t
            index--;
            ans++;
        }
        index = -1
        var max = -1 * 0x3f3f3f3f; //一个很小的数
        for (i in 0..n) {
            if (max < nums[i]) {
                index = i
                max = nums[i]
            }
        }
        while (index < n - 1) {
            let t = nums[index];
            nums[index] = nums[index + 1]
            nums[index + 1] = t
            index++;
            ans++;
        }
        return ans;
    }
}

main() {
    let s = Solution();
}
