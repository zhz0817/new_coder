class Solution {
public:
    int maxCount(int m, int n, vector<vector<int>>& ops) {
        for(auto& tmp:ops){
            m = min(m,tmp[0]);
            n = min(n,tmp[1]);
        }
        return m*n;
    }
};