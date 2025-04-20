#include <bits/stdc++.h>
using namespace std;
typedef unsigned long long ull;
typedef long long ll;
#define max_int INT_MAX;
#define min_int INT_MIN;

int main(){
    ll n,a,b;
    cin>>n>>a>>b;
    vector<ll> vector1(a);
    vector<ll> vector2(b);
    for(int i=0;i<a;i++){
        ll temp;
        cin>>temp;
        vector1[i]=temp;
    }
    for(int i=0;i<b;i++){
        ll temp;
        cin>>temp;
        vector2[i]=temp;
    }
    ll ans1 = 0,ans2 = 0;
    ll index1 = 0;
    ll index2 = 0;
    int res[5][5];
    res[0][1] = -1;res[0][2] = 1;res[0][3] = 1;res[0][4] = -1;
    res[1][2] = -1;res[1][3] = 1;res[1][4] = -1;
    res[2][3] = -1;res[2][4] = 1;
    res[3][4] = 1;
    for(int i=0;i<5;i++){
        for(int j=0;j<=i;j++){
            if(i==j){
                res[i][j]=0;
            }
            else{
                res[i][j]=-1*res[j][i];
            }
        }
    }
    for(int i=0;i<n;i++){
        ll val1 = vector1[index1++];
        ll val2 = vector2[index2++];
        int flag = res[val1][val2];
        if(flag==1){
            ans1++;
        }
        else if(flag==0){

        }
        else{
            ans2++;
        }
        index1%=a;
        index2%=b;
    }
    cout<<ans1<<" "<<ans2<<endl;
    return 0; 
}