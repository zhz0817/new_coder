class Solution {
    public int findClosestNumber(int[] nums) {
        int ans = 0;
        int max = Integer.MAX_VALUE;
        for(int num:nums){
            int val = Math.abs(num);
            if(val<max){
                max=val;
                ans=num;
            }
            else if(val==max){
                if(num>ans)
                    ans=num;
            }
        }
        return ans;
    }
}