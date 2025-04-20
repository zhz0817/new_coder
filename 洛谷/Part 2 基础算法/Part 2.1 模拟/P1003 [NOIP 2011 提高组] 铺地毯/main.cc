#include <bits/stdc++.h>
using namespace std;
typedef unsigned long long ull;
typedef long long ll;
#define max_int INT_MAX;
#define min_int INT_MIN;

int main(){
    ll n;
    cin>>n;
    vector<vector<int>> vector1;
    for(int i=0;i<n;i++){
        vector<int> temp;
        for(int j=0;j<4;j++){
            int val;
            cin>>val;
            temp.emplace_back(val);
        }
        vector1.emplace_back(temp);
    }
    ll x,y;
    cin>>x>>y;
    ll ans = -1;
    for(int i=0;i<n;i++){
        ll min_x = vector1[i][0];
        ll max_x = min_x+vector1[i][2];
        ll min_y = vector1[i][1];
        ll max_y = min_y+vector1[i][3];
        if(x>=min_x&&x<=max_x&&y>=min_y&&y<=max_y){
            ans = i+1;
        }
    }
    cout<<ans<<endl;
    return 0;
}