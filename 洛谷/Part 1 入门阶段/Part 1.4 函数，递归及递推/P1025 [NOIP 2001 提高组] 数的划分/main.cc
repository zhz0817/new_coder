#include <bits/stdc++.h>
#include <limits.h>
using namespace std;
typedef unsigned long long ull;
typedef long long ll;
#define max_int INT_MAX;
#define min_int INT_MIN;
ll ans = 0;

void dfs(ll n,ll left,ll right,int min){
    if(n==1){
        int res = right-left;
        if(res>=min){
            ans++;
        }
        return;
    }
    for(ll i=left+min;i<=right;i++){
        ll res = right-i+min;
        if((res/min)<n){
            break;
        }
        dfs(n-1,i,right,i-left);
    }
}
int main(){
    ll a,b;
    cin>>a>>b;
    for(ll i=1;i<=a;i++){
        vector<int> vector1;
        ll res = a-i;
        if((res/i)<b-1){
            break;
        }
        dfs(b-1,i,a,i);
//        cout<<ans<<endl;
    }
    cout<<ans<<endl;
    return 0;
}