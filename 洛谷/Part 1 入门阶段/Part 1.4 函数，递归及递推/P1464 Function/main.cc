#include <bits/stdc++.h>
#include <limits.h>
using namespace std;
typedef unsigned long long ull;
typedef long long ll;
#define max_int INT_MAX;
map<string,ll> map1;
ll fun(ll a,ll b,ll c){
    auto iter = map1.find(to_string(a)+"!"+to_string(b)+"!"+to_string(c));
    if(iter!=map1.end()){
        return iter->second;
    }
    ll ans = 0;
    if(a<=0||b<=0||c<=0){
        ans = 1;
    }
    else if(a>20||b>20||c>20){
        ans = fun(20,20,20);
    }
    else if(a<b&&b<c){
        ans = fun(a,b,c-1)+fun(a,b-1,c-1)-fun(a,b-1,c);
    }
    else{
        ans = fun(a-1,b,c)+fun(a-1,b-1,c)+fun(a-1,b,c-1)-fun(a-1,b-1,c-1);
    }
    string s = "";
    s+=to_string(a);
    s+="!";
    s+=to_string(b);
    s+="!";
    s+=to_string(c);
    map1[s]=ans;
    return ans;
}
int main(){
    ll a,b,c;
    do{
        cin>>a>>b>>c;
        // cout<<a<<"  "<<b<<"  "<<c<<endl;
        if(a==-1&&b==-1&&c==-1){
            break;
        }
        ll ans = fun(a,b,c);
        // string s = "w(%d, %d, %d) = %lld";
        printf("w(%lld, %lld, %lld) = %lld\n",a,b,c,ans);
    }while (true);
    return 0;
}