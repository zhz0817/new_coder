class Solution {
public:
    long long minimumMoney(vector<vector<int>>& transactions) {
        long long sum = 0;//总亏钱数
        for(vector<int>& tmp:transactions){
            if(tmp[0]>tmp[1]){
                sum+=(tmp[0]-tmp[1]);
            }
        }
        long long ans = 0;
        for(vector<int>& tmp:transactions){
            if(tmp[0]>tmp[1]){
                ans = max(ans,sum+tmp[1]);
            }else{
                ans = max(ans,sum+tmp[0]);
            }
        }
        return ans;
    }
};