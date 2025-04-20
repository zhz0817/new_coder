#include <bits/stdc++.h>
using namespace std;
typedef unsigned long long ull;
typedef long long ll;
#define max_int INT_MAX;
#define min_int INT_MIN;

int main(){
    ll a,b;
    cin>>a>>b;
    ll ans = 0;
    for(ll i=a;i<=b;i++){
        ll temp = i;
        while(temp!=0){
            ll mod = temp%10;
            if(mod==2){
                ans++;
            }
            temp/=10;
        }
    }
    cout<<ans<<endl;
    return 0; 
}