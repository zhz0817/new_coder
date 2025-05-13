#include "bits/stdc++.h"
using namespace std;

void dfs(int n) {
    for (int i = 14; i >= 0; i--) {
        int val = pow(2, i);
        if (val <= n) {
            if (i == 1) {
                cout << "2";
            } else if (i == 0) {
                cout << "2(0)";
            } else {
                cout << "2(";
                dfs(i);
                cout << ")";
            }
            n -= val;
            if (n != 0) {
                cout << "+";
            }
        }
    }
}
int main() {
    int n;
    cin >> n;
    dfs(n);
    return 0;
}