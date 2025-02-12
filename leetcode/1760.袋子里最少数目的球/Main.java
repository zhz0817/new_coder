class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        while (left <= right) {
            int y = (left + right) / 2;
            long ops = 0;
            for (int x : nums) {
                ops += x/y;
                if(x%y==0){//假如X等于9，y=3，那么需要拆2次就能拆出来3个3，所以整除的时候再减去1
                    ops--;
                }
                // ops += (x - 1) / y; //和上面的操作等价
            }
            if (ops <= maxOperations) {
                ans = y;
                right = y - 1;
            } else {
                left = y + 1;
            }
        }
        return ans;
    }
}