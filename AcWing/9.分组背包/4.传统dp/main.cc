#include <bits/stdc++.h>
using namespace std;

#define FOR_INC(i, start, end) for (int i = start; i < end; ++i)
#define FOR_DEC(i, start, end) for (int i = start; i > end; --i)
#define FOR_INC_EQUAL(i, start, end) for (int i = start; i <= end; ++i)
#define FOR_DEC_EQUAL(i, start, end) for (int i = start; i >= end; --i)

const int N = 200;
int dp[N][N];
int weights[N][N];
int values[N][N];
int amounts[N];
int main()
{
    int n,v;
    cin>>n>>v;
    FOR_INC_EQUAL(i,1,n){
        cin>>amounts[i];
        FOR_INC_EQUAL(j,1,amounts[i]){
            cin>>weights[i][j]>>values[i][j];
        }
    }
    FOR_INC_EQUAL(i,1,n){
        FOR_INC_EQUAL(j,1,v){
            dp[i][j] = dp[i-1][j];
            FOR_INC_EQUAL(k,1,amounts[i]){
                if(j>=weights[i][k]){
                    dp[i][j] = max(dp[i][j],dp[i-1][j-weights[i][k]]+values[i][k]);
                }
            }
        }
    }
    cout<<dp[n][v]<<endl;
    return 0;
}