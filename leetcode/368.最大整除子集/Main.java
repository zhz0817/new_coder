class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxValue = 1;
        int maxLength = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0)
                    dp[i] = Math.max(dp[i],1+dp[j]);
            }
            if(dp[i]>maxLength){
                maxValue = nums[i];
                maxLength = dp[i];
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(maxLength==1){
            ans.add(nums[0]);
            return ans;
        }
        for(int i=n-1;i>=0&&maxLength>0;i--){
            if(dp[i]==maxLength&&maxValue%nums[i]==0){
                ans.add(nums[i]);
                maxLength--;
                maxValue = nums[i];
            }
        }
        return ans;
    }
}