#include "bits/stdc++.h"

using namespace std;
class OrderedStream {
public:
    int ptr = 1;
    int n;
    vector<string> ss;
    OrderedStream(int n) {
        ss.resize(n+1, "");//初始化vector
        this-> n = n;
    }

    vector<string> insert(int idKey, string value) {
        ss[idKey] = value;
        if(ss[ptr].empty()){
            return vector<string>();
        }
        vector<string> ans;
        ans.push_back(ss[ptr]);
        int last = ptr;//记录最后一个连续序列的索引
        for(int i=ptr+1;i<=n;i++){
            if(!ss[i].empty()){
                last = i;
                ans.push_back(ss[i]);
            }else{ //要求是连续的递增序列，如果不连续了就终止
                break;
            }
        }
        ptr = last+1;
        return ans;
    }
};

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream* obj = new OrderedStream(n);
 * vector<string> param_1 = obj->insert(idKey,value);
 */