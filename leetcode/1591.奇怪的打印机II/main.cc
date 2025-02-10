class Solution {
   public:
    bool isPrintable(vector<vector<int>>& targetGrid) {
        unordered_map<int, vector<int>> map1;
        int n = targetGrid.size();
        int m = targetGrid[0].size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int v = targetGrid[i][j];
                if (map1.find(v) == map1.end()) {
                    map1[v] = {i, i, j, j};
                } else {
                    map1[v][0] = min(map1[v][0], i);
                    map1[v][1] = max(map1[v][1], i);
                    map1[v][2] = min(map1[v][2], j);
                    map1[v][3] = max(map1[v][3], j);
                }
            }
        }
        vector<vector<int>> graph(61);
        vector<int> indegree(61, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = targetGrid[i][j];
                for (int pre = 1; pre <= 60; pre++) {
                    if (map1.find(pre) == map1.end() || pre == cur) {
                        continue;
                    }
                    auto& bound = map1[pre];
                    if (i >= bound[0] && i <= bound[1] && j >= bound[2] &&
                        j <= bound[3]) {  // cur被pre包裹了，先填涂pre
                        indegree[cur]++;
                        graph[pre].push_back(cur);
                    }
                }
            }
        }
        queue<int> queue1;
        for (int i = 0; i < 61; i++) {
            if (indegree[i] == 0 && map1.find(i) != map1.end()) {
                queue1.push(i);
            }
        }
        while (!queue1.empty()) {
            int top = queue1.front();
            queue1.pop();
            for (int i = 0; i < graph[top].size(); i++) {
                int next = graph[top][i];
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue1.push(next);
                }
            }
        }
        for (int i = 0; i < indegree.size(); i++) {
            if (indegree[i] != 0) {
                return false;
            }
        }
        return true;
    }
};