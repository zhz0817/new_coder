class Solution {
public:
    int numBusesToDestination(vector<vector<int>>& routes, int source, int target) {
        if(source == target){
            return 0;
        }
        unordered_map<int,vector<int>> map1;
        int index = 0;
        for(auto& route:routes){
            for(int& t:route){
                map1[t].push_back(index);
            }
            index++;
        }
        if(map1.find(source) == map1.end()){
            return -1;
        }
        int ans = 1;
        queue<int> queue1;
        unordered_set<int> isVisited;
        for(int i : map1[source]){
            index = i;
            isVisited.insert(index);
            for(int cur : routes[index]){
                if(cur == target){
                    return 1;
                }
                queue1.push(cur);
            }
        }
        while(!queue1.empty()){
            int length = queue1.size();
            for(int i=0;i<length;i++){
                int top = queue1.front();
                queue1.pop();
                vector<int> indexes = map1[top];
                for(int next : indexes){
                    if(isVisited.find(next) == isVisited.end()){
                        isVisited.insert(next);
                        for(int k : routes[next]){
                            if( k == target){
                                return ans+1;
                            }
                            queue1.push(k);
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }
};