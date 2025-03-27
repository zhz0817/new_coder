class Solution {
public:
    long long minimumCost(string s) {
        int n = s.length();
        vector<long long> dp(n+1,0);
        for(int i=2;i<=n;i++){
            char cur = s[i-1];
            char pre = s[i-2];
            if(cur == pre){
                dp[i] = dp[i-1];
            }else{
                dp[i] = dp[i-1] + min(i-1,n-(i-1));
            }
        }
        return dp[n];
    }
};