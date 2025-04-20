#include <bits/stdc++.h>
using namespace std;
typedef unsigned long long ll;
bool is_prime(int);
void dfs(vector<int>&,int,ll,int);
bool is_prime(ll m){
    if(m<=1){
        return 0;
    }
    if(m==2){
        return 1;
    }
    if(m%2==0){
        return false;
    }
    for(int i=3;i< sqrt(m);i+=2){
        if(m%i==0){
            return 0;
        }
    }
    return 1;
}
ll ans = 0;
void dfs(vector<int>& vector1,int m,ll sum,int pos){
   if(m==0){
//       cout<<sum<<endl;
       if(is_prime(sum)){
//           cout<<"-----"<<endl;
           ans++;
       }
   }
   for(int i=pos;i<vector1.size();i++){
       dfs(vector1,m-1,sum+vector1[i],i+1);
   }
}
int main(){
    int n,k;
    cin>>n>>k;
    vector<int> vector1(n);
    ll sum = 0;
    for(int i=0;i<n;i++){
        int temp;
        cin>>temp;
        vector1[i]=temp;
        sum+=temp;
    }
//    sort(vector1.begin(),vector1.end(),[](int a,int b){
//        return a<b;
//    });
//    ll ans = 0;
    dfs(vector1,k,0,0);
    cout<<ans<<endl;
    return 0;
}