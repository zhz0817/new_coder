#include <bits/stdc++.h>
using namespace std;

#define FOR_INC(i, start, end) for (int i = start; i < end; ++i)
#define FOR_DEC(i, start, end) for (int i = start; i > end; --i)
#define FOR_INC_EQUAL(i, start, end) for (int i = start; i <= end; ++i)
#define FOR_DEC_EQUAL(i, start, end) for (int i = start; i >= end; --i)

const int NN = 114514;
int main()
{
    int N,V,M;//数量、最大容量、最大重量
    cin>>N>>V>>M;
    vector<int> volumn(NN,0);//体积
    vector<int> weights(NN,0);//重量
    vector<int> values(NN,0);//价值
    FOR_INC_EQUAL(i, 1, N){
        cin>>volumn[i]>>weights[i]>>values[i];
    }
    int dp[N+1][V+1][M+1];
    memset(dp,0,sizeof dp);
    FOR_INC_EQUAL(i,1,N){
        FOR_INC_EQUAL(j,1,V){
            FOR_INC_EQUAL(k,1,M){
                if(k<weights[i]||j<volumn[i]){
                    dp[i][j][k] = dp[i-1][j][k];
                }else{
                    dp[i][j][k] = max(dp[i-1][j][k],dp[i-1][j-volumn[i]][k-weights[i]]+values[i]);
                }
            }
        }
    }
    cout<<dp[N][V][M];
    return 0;
}