#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
map<int,int> map1;
ll dfs(int num){
    auto iter = map1.find(num);
    if(iter!=map1.end()){
        return iter->second;
    }
    ll ans = 1;
    ll half = num/2;
    for(ll i=half;i>=1;i--){
        ans+=dfs(i);
    }
    map1[num]=ans;
    return ans;
}

int main(){
    int n;
    cin>>n;
    ll ans = dfs(n);
    cout<<ans<<endl;
    return 0;
}