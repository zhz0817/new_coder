#include <bits/stdc++.h>
using namespace std;
typedef unsigned long long ull;
typedef long long ll;
#define max_int INT_MAX;
#define min_int INT_MIN;

int main(){
    ll n;
    cin>>n;
    auto cmp=[](const int& a,const int& b){
        return a<b;
    };
    set<ll,decltype(cmp)> set1(cmp);
    for(ll i=0;i<n;i++){
        ll temp;
        cin>>temp;
        set1.insert(temp);
    }
    cout<<set1.size()<<endl;
    int count = 0;
    for(int n:set1){
        if(count==set1.size()-1){
            cout<<n<<endl;
        }
        else{
            cout<<n<<" ";
        }
        count++;
    }
    return 0;
}