class Solution {
    public boolean dfs(int[] nums,int k,int count){
        for(int i=0;i<nums.length;i++){
            if(i+count>nums.length){
                break;
            }
            int sum = nums[i];
            for(int j=i+1;j<i+count;j++){
                sum|=nums[j];
            }
            if(sum>=k){
                return true;
            }
        }
        return false;
    }
    public int minimumSubarrayLength(int[] nums, int k) {
        int left = 1;
        int right = nums.length;
        boolean flag1 = false;
        while (left<=right){
            int mid = left+(right-left)/2;
            boolean flag = dfs(nums,k,mid);
            if(flag){
                flag1 = true;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        if(!flag1){
            return -1;
        }
        return left;
    }

}