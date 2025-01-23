class Solution {
public:
    vector<vector<int>> memo;//缓存
    vector<vector<int>> children;

    int dfs(int cur,int parent,int count,vector<int>& coins, int k){
        if(memo[cur][count]>=0){
            return memo[cur][count];
        }
        int res0 = (coins[cur]>>count)-k;//第一种方法收集
        int res1 = coins[cur]>>(count+1);//第二种方法收集
        for(int child:children[cur]){
            if(child==parent){
                continue;
            }
            res0 += dfs(child,cur,count,coins,k);//后续count不动，既可以用第一种也可以用第二种
            if(count+1<14){//保证不越界的情况才可以继续，后续也是既可以用第一种也可以用第二种
                res1 += dfs(child,cur,count+1,coins,k);
            }
        }
        return memo[cur][count] = max(res0,res1);
    }
    int maximumPoints(vector<vector<int>>& edges, vector<int>& coins, int k) {
        int n = coins.size();
        children = vector<vector<int>>(n);
        for(const auto& edge:edges){
            children[edge[0]].push_back(edge[1]);
            children[edge[1]].push_back(edge[0]);
        }
        memo.resize(n);
        for(int i=0;i<n;i++){
            memo[i].resize(14,-1);
        }
        return dfs(0,-1,0,coins,k);
    }
};