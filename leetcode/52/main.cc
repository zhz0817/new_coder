class Solution {
public:
    int ans = 0;
    int n;
    int isVisitedY[100],isVisitedK1[100],isVisitedK2[100];//y轴，副对角线，主对角线
    void dfs(int x){
        if(x>n){
            ans++;
            return;
        }
        for(int y=1;y<=n;y++){
            if(!isVisitedY[y]&&!isVisitedK1[x+y]&&!isVisitedK2[x-y+n]){
                isVisitedY[y] = 1;
                isVisitedK1[x+y] = 1;
                isVisitedK2[x-y+n] = 1;
                dfs(x+1);
                isVisitedY[y] = 0;
                isVisitedK1[x+y] = 0;
                isVisitedK2[x-y+n] = 0;
            }
        }
    }
    int totalNQueens(int n) {
        this->n = n;
        dfs(1);
        return this->ans;
    }
};