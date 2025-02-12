class Solution {
   public:
    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        int n = edges.size();
        int min_dis = INT32_MAX;
        int ans = -1;
        auto calc_dis = [&](int x) -> vector<int> {
            vector<int> dis(n, INT32_MAX);
            int d = 0;
            while (x != -1 && dis[x] == INT32_MAX) {
                dis[x] = d;
                d++;
                x = edges[x];
            }
            return dis;
        };
        auto dis1 = calc_dis(node1);
        auto dis2 = calc_dis(node2);
        for (int i = 0; i < n; i++) {
            int dis = max(dis1[i], dis2[i]);
            if (dis < min_dis) {
                min_dis = dis;
                ans = i;
            }
        }
        return ans;
    }
};