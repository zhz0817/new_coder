class Solution {
   public:
    int minimumTime(int n, vector<vector<int>>& relations, vector<int>& time) {
        vector<vector<int>> graph(n);
        vector<int> indegree(n, 0);
        for (auto& r : relations) {
            int left = r[0] - 1;
            int right = r[1] - 1;
            graph[left].push_back(right);
            indegree[right]++;
        }
        int ans = 0;
        queue<int> queue1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue1.push(i);
            }
        }
        vector<int> dp(n, 0);
        while (!queue1.empty()) {
            int cur = queue1.front();
            queue1.pop();
            dp[cur] += time[cur];
            ans = max(ans, dp[cur]);
            for (int next : graph[cur]) {
                dp[next] = max(dp[next], dp[cur]);
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue1.push(next);
                }
            }
        }
        return ans;
    }
};