#include <bits/stdc++.h>
using namespace std;
typedef unsigned long long ull;
typedef long long ll;
#define max_int INT_MAX;
#define min_int INT_MIN;

int main() {
  ll n;
  cin >> n;
  vector<ll> vector1(n + 1);
  for (int i = 0; i <= n; i++) {
    ll val;
    cin >> val;
    vector1[i] = val;
  }
  string s = "";
  for(int i=0;i<=n;i++){
    ll val = vector1[i];
    if(val>0){
        if(i>0){
          s+='+';
        }
    }
    else if(val==0){
      continue;
    }
    else{
      s+="-";
    }
    if(val<0){
      val*=-1;
    }
    if(val>1||n-i==0)
      s+=to_string(val);
    if(n-i>0){
      s+="x";
      if(n-i>1){
        s+="^";
        s+=to_string(n-i);
      }
    }
  }
  cout<<s<<endl;
  return 0;
}