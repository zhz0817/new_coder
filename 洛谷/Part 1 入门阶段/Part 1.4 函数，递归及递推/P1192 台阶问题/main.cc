#include <bits/stdc++.h>
#include <limits.h>
using namespace std;
typedef unsigned long long ull;
typedef long long ll;
#define max_int INT_MAX;
ll mod = 100003;
int main()
{
    ll a, b;
    cin >> a >> b;
    ll ans = 0;
    vector<ll> dp(a + 1);
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= a; i++)
    {
        for (ll j = i - b; j < i; j++)
        {
            if(j<0){
                continue;
            }
            dp[i] += dp[j];
            dp[i] %= mod;
        }
    }
    cout << dp[a] << endl;
    return 0;
}