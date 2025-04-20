#include <bits/stdc++.h>
using namespace std;
typedef unsigned long long ull;
typedef long long ll;
#define max_int INT_MAX;
#define min_int INT_MIN;

int main() {
    string t = "";
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int count4 = 0;
    string ans1 = "";
    string ans2 = "";
    bool flag = true;
    do {
        cin >> t;
        int length = t.size();
        for (int i = 0; i < length; i++) {
            char ch = t[i];
            if (ch == 'W') {
                count1++;
                count3++;
            } else if (ch == 'L') {
                count2++;
                count4++;
            } else if (ch == 'E') {
                flag = false;
                break;
            }
            if ((count1 >= 11 || count2 >= 11) &&
                ((count1 - count2 >= 2) || (count2 - count1 >= 2))) {
                ans1 += (to_string(count1) + ":" + to_string(count2) + "\n");
                count1 = 0;
                count2 = 0;
            }
            if ((count3 >= 21 || count4 >= 21) &&
                ((count3 - count4 >= 2) || (count4 - count3 >= 2))) {
                ans2 += (to_string(count3) + ":" + to_string(count4) + "\n");
                count3 = 0;
                count4 = 0;
            }
        }
    } while (flag);
    ans1 += (to_string(count1) + ":" + to_string(count2) + "\n" + "\n");
    ans2 += (to_string(count3) + ":" + to_string(count4) + "\n");
    cout << ans1 << ans2;
    return 0;
}