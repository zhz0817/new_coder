#include <bits/stdc++.h>
using namespace std;

#define FOR_INC(i, start, end) for (int i = start; i < end; ++i)
#define FOR_DEC(i, start, end) for (int i = start; i > end; --i)
#define FOR_INC_EQUAL(i, start, end) for (int i = start; i <= end; ++i)
#define FOR_DEC_EQUAL(i, start, end) for (int i = start; i >= end; --i)

const int N = 114514;
int main() {
  int n, v;
  cin >> n >> v;
  vector<int> weights(N, 0);
  vector<int> values(N, 0);
  int count = 0;
  FOR_INC_EQUAL(i, 1, n) {
    int v1, w, s;
    cin >> v1 >> w >> s;
    if (s == -1) {
      count++;
      weights[count] = v1;
      values[count] = w;
      continue;
    } else if (s == 0) {
      s = v / v1;
    }
    int k = 1;
    while (s >= k) {
      count++;
      weights[count] = v1 * k;
      values[count] = w * k;
      s -= k;
      k *= 2;
    }
    if (s > 0) {
      count++;
      weights[count] = v1 * s;
      values[count] = w * s;
    }
  }
  int dp[N];
  memset(dp, 0, sizeof(dp));
  FOR_INC_EQUAL(i, 1, count) {
    FOR_DEC_EQUAL(j, v, weights[i]) {
      dp[j] = max(dp[j], dp[j - weights[i]] + values[i]);
    }
  }
  cout << dp[v] << endl;
  return 0;
}