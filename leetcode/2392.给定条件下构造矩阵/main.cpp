class Solution {
   public:
    vector<vector<int>> buildMatrix(int k, vector<vector<int>>& rowConditions,
                                    vector<vector<int>>& colConditions) {
        auto func = [&](int flag) -> vector<int> {
            vector<vector<int>> conditions;
            if (flag == 0) {
                conditions = std::move(rowConditions);
            } else {
                conditions = std::move(colConditions);
            }
            vector<vector<int>> graph(k);
            vector<int> degree(k);
            for (const auto& con : conditions) {
                graph[con[0] - 1].push_back(con[1] - 1);
                degree[con[1] - 1]++;
            }
            queue<int> queue1;
            for (int i = 0; i < k; i++) {
                if (degree[i] == 0) {
                    queue1.push(i);
                }
            }
            vector<int> idx(k);
            int index = 0;
            while (!queue1.empty()) {
                int top = queue1.front();
                queue1.pop();
                idx[top] = index++;
                for (int v : graph[top]) {
                    degree[v]--;
                    if (degree[v] == 0) {
                        queue1.push(v);
                    }
                }
            }
            if (index != k) {
                return {};
            }
            return idx;
        };
        auto rowIdx = func(0);
        auto colIdx = func(1);
        // rowIdx[i]：表示元素 i+1 在矩阵中的行索引。
        // colIdx[i]：表示元素 i+1 在矩阵中的列索引。
        if (rowIdx.empty() || colIdx.empty()) {
            return {};
        }
        vector<vector<int>> ans(k, vector<int>(k, 0));
        for (int i = 0; i < k; i++) {
            ans[rowIdx[i]][colIdx[i]] = i + 1;
        }
        return ans;
    }
};