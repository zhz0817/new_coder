class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int max = 0X3f3f3f3f;
        int n = floor.length();
        int[][] dp = new int[n+1][numCarpets+1];//前 i 个地砖用 j 个地毯后的最少白砖数量
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],max);
        }
        dp[1][0] = floor.charAt(0)-'0';
        for (int i = 1; i <= carpetLen; i++) {
            dp[i][1] = 0;
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<=numCarpets;j++){
                char ch = floor.charAt(i-1);
                if(ch == '1'){
                    dp[i][j] = Math.min(dp[i][j],1+dp[i-1][j]);
                }else{
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j]);
                }
                if( i-carpetLen>0 && j>=1){ //滑动窗口
                    dp[i][j] = Math.min(dp[i][j],dp[i-carpetLen][j-1]);
                }
            }
        }
        int ans = max;
        for(int i=0;i<=numCarpets;i++){
            ans = Math.min(ans,dp[n][i]);
        }
        return ans;//只按砖块个数更新了，没按毯子个数更新，所以答案一定是最后一列的数据，但不一定是最后一个
    }
}