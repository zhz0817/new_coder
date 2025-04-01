class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n+1];
        for(int i=n-1;i>=0;i--){
            int[] q = questions[i];
            int j = i+1+q[1];
            dp[i] = Math.max(dp[i+1],q[0]+(j < n ? dp[j] : 0));
        }
        return dp[0];
    }
}