class Solution {
    int[] memo = new int[10000];
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        return dfs(1,prices);
    }

    private int dfs(int i,int[] prices){
        if(i*2>=prices.length){
            return prices[i-1];
        }
        if(memo[i]!=0){
            return memo[i];
        }
        int res = Integer.MAX_VALUE;
        for(int j=i+1;j<=i*2+1;j++){
            res = Math.min(res,dfs(j,prices));
        }
        memo[i] = res+prices[i-1];
        return memo[i];
    }
}