#include "bits/stdc++.h"

using namespace std;

#define FOR_INC(i, start, end) for (int i = start; i < end; ++i)
#define FOR_DEC(i, start, end) for (int i = start; i > end; --i)
#define FOR_INC_EQUAL(i, start, end) for (int i = start; i <= end; ++i)
#define FOR_DEC_EQUAL(i, start, end) for (int i = start; i >= end; --i)
// #define int long long

void getNums(string s) {
    string t;
    for (char ch : s) {
        if (ch == '[') {
            t += '{';
        } else if (ch == ']') {
            t += '}';
        } else if (ch == '"') {
            t += "'";
        } else {
            t += ch;
        }
    }
    cout << t << endl;
}
class Fenwick {
public:
    vector<int> f;
    Fenwick(vector<int> &nums) : f(nums.size() + 1) {
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }
    static int lowBit(int n) { return n & -n; }
    void add(int i, int val) {
        for (; i < f.size(); i += lowBit(i)) {
            f[i] += val;
        }
    }

    int query(int i) {
        int res = 0;
        for (; i > 0; i -= lowBit(i)) {
            res += f[i];
        }
        return res;
    }
};

class UnionFind {
    std::vector<int> root;
    std::vector<int> rank;

public:
    explicit UnionFind(int size) {
        root.resize(size);
        rank.resize(size);
        for (int i = 0; i < size; ++i) {
            root[i] = rank[i] = i;
        }
    }

    int find(int x) {
        if (x == root[x]) return x;
        return root[x] = find(root[x]);
    }

    void connect(int x, int y) {
        if (x > y) {
            connect(y, x);
        }
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    bool isConnected(int x, int y) { return find(x) == find(y); }
};

class KMP {
private:
    vector<vector<int>> dp;
    string pat_;
    int size = 128;

public:
    KMP(const string &pat) {
        this->pat_ = pat;
        int n = pat.length();
        dp.resize(n, vector<int>(size, 0));
        dp[0][pat[0]] = 1;
        int pre = 0;
        for (int j = 1; j < n; j++) {
            for (int c = 0; c < size; c++) {
                dp[j][c] = dp[pre][c];
            }
            dp[j][pat[j]] = j + 1;
            pre = dp[pre][pat[j]];
        }
    }

    int search(const string &txt) {
        int M = pat_.size();
        int N = txt.size();
        int j = 0;
        for (int i = 0; i < N; i++) {
            j = dp[j][txt[i]];
            if (j == M) {
                return i - M + 1;
            }
        }
        return -1;
    }
};


class Solution {
public:
    vector<int> getFinalState(vector<int>& nums, int k, int multiplier) {
        auto cmp = [](pair<int,int>& a,pair<int,int>& b){
            if(a.first!=b.first)
                return a.first>b.first;
            return a.second>b.second;//先按照大小排序，大小一样按照下标排序
        };
        priority_queue<pair<int,int>,vector<pair<int,int>>, decltype(cmp)> pq(cmp);
        for(int i=0;i<nums.size();i++){
            pq.emplace(nums[i],i);//原地构造，避免额外拷贝
        }
        for(int i=0;i<k;i++){
            auto tmp = pq.top();//取最小值
            pq.pop();
            tmp.first*=multiplier;
            pq.emplace(tmp.first,tmp.second);
        }
        while(!pq.empty()){
            auto tmp = pq.top();
            nums[tmp.second] = tmp.first;//原地覆盖
            pq.pop();
        }
        return nums;
    }
};

signed main() {
    Solution s;
    vector<vector<int>> grid{{8, 5, 2}, {6, 4, 1}, {9, 7, 3}};
    vector<int> nums{1, 2, 3, 4, 3, 2, 5};
    //    std::ios::sync_with_stdio(false);
    //    std::cin.tie(nullptr);
    //    std::cout.tie(nullptr);
    return 0;
}
