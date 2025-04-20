#include <bits/stdc++.h>
using namespace std;
typedef unsigned long long ull;
typedef long long ll;
#define max_int INT_MAX;
// 面向内 往左-，往右+
// 面向外，往左+，往右-
int main() {
    ll n, m;
    cin >> n >> m;
    string ss[n];
    bool flags[n];
    for (int i = 0; i < n; i++) {
        cin >> flags[i];
        cin >> ss[i];
    }
    int nums[m];
    for (int i = 0; i < m; i++) {
        int temp1, temp2;
        cin >> temp1 >> temp2;
        if (temp1 == 0) {
            nums[i] = -1 * temp2;
        } else {
            nums[i] = temp2;
        }
    }
    int index = 0;
    string ans = "";
    for (int i = 0; i < m; i++) {
        int val = nums[i];
        bool flag = flags[index];
        if (flag) {
            if (val > 0) {
                index -= val;
            } else {
                index -= val;
            }
        } else {
            if (val > 0) {
                index += val;
            } else {
                index += val;
            }
        }
        index += n;
        index %= n;
        ans = ss[index];
    }
    cout << ans << endl;
    return 0;
}