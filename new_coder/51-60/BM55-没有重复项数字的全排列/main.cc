void dfs(vector<vector<int>>& arr,vector<int>& isVisited,vector<int>& tmp,vector<int>& num){
        if(tmp.size() == isVisited.size()){//思考边界
            arr.emplace_back(tmp);//push_back有没有拷贝构造，传进去的到底是真实的tmp还是tmp复制后的副本呢？
            return;
        }
        for(int i=0;i<isVisited.size();i++){
            if(isVisited[i] == 0){
                isVisited[i] = 1;
                tmp.push_back(num[i]);//添加到最后一位
                dfs(arr,isVisited,tmp,num);
                tmp.pop_back();//删除最后一个元素
                isVisited[i] = 0; //恢复现场
            }
        }
    }
    vector<vector<int>> permute(vector<int>& num) {
        // write code here
        vector<vector<int>> ans;
        int n = num.size();
        vector<int> isVisited(n,0);//如果isVisited[i] = 0 ,代表num[i]还没有被使用过
        vector<int> tmp;//最开始长度为0，存储每个排列，每找到一个合适的数就添加进去一个
        dfs(ans,isVisited,tmp,num);
        return ans;
    }