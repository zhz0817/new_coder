class Solution {
    public int subsetXORSum(int[] nums) {
        int len = 1 << nums.length;
        int count=0;
        for (int i = 0; i < len; i++) {
            int flag=0;
            int index = i;//用二进制的值模拟所有可能性
            for (int j = 0; j < nums.length; j++) {
                if ((index & 1) == 1) {
                    flag^=nums[j];
                }
                index >>= 1;
            }
            count+=flag;
        }
        return count;
    }
}