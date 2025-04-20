#include <iostream>
using namespace std;
int main() {
    int n;
    double sum = 0;
    int val = 1;
    cin>>n;
    int ans = 0;
    while (sum<=n){
        sum+=1.0/val;
        val++;
        ans++;
    }
    cout<<ans<<endl;
}