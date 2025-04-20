#include <bits/stdc++.h>
#include <limits.h>
using namespace std;
typedef unsigned long long ull;
typedef long long ll;
#define max_int INT_MAX;

int main(){
    ll a,b,c;
    cin>>a>>b>>c;
    ll d = b-a;
    ll ans = 0;
    ll an = a+(c-1)*d;
    ans = (a+an)*c/2;
    cout<<ans<<endl;
    return 0;
}