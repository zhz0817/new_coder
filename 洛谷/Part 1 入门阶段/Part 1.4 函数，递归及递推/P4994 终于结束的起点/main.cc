#include <bits/stdc++.h>
using namespace std;
typedef unsigned long long ull;
typedef long long ll;
#define max_int INT_MAX;
#define min_int INT_MIN;

int main(){
    ll n;
    cin>>n;
    ll ans = 0;
    vector<ll> vector1;
    vector1.emplace_back(0);
    vector1.emplace_back(1);
    int pos = 2;
    while(true){
        ll val = vector1[pos-2]+vector1[pos-1];
        val%=n;
        if(vector1[pos-1]==0&&val==1){
            ans = pos;
            break;
        } 
        vector1.emplace_back(val);
        pos++;
    }
    cout<<ans-1<<endl;
    return 0;
}