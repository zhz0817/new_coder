class Solution {
   public:
    vector<int> findBall(vector<vector<int>>& grid) {
        vector<int> res;
        int m = grid.size();
        int n = grid[0].size();
        for (int i = 0; i < n; i++) {
            int x = 0;
            int y = i;
            bool flag = true;
            while (x < m) {
                if (grid[x][y] == 1) {
                    if (y == n - 1) {
                        res.push_back(-1);
                        flag = false;
                        break;
                    } else {
                        if (grid[x][y + 1] == -1) {
                            res.push_back(-1);
                            flag = false;
                            break;
                        } else {
                            x++;
                            y++;
                        }
                    }
                } else {
                    if (y == 0) {
                        res.push_back(-1);
                        flag = false;
                        break;
                    } else {
                        if (grid[x][y - 1] == 1) {
                            res.push_back(-1);
                            flag = false;
                            break;
                        } else {
                            x++;
                            y--;
                        }
                    }
                }
            }
            if (flag) res.push_back(y);
        }
        return res;
    }
};