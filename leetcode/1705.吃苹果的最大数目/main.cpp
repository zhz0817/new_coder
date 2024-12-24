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

class KMPAutoMachine {
private:
    vector<vector<int>> dp;
    string pat_;
    int size = 128;

public:
    KMPAutoMachine(const string &pat) {
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

class KMP{
    vector<int> build_next(const string& t){
        vector<int> next;
        next.push_back(0);
        int i=1;
        int prefix_len = 0;//共同的前后缀长度
        while(i<t.size()){
            if(t[prefix_len] == t[i]){
                prefix_len++;
                next.push_back(prefix_len);
                i++;
            }else{
                if(prefix_len == 0){
                    next.push_back(0);
                    i++;
                }else{
                    prefix_len = next[prefix_len-1];
                }
            }
        }
        return next;
    }

    int search(const string& s,const string& t){
        vector<int> next = build_next(t);
        int i=0,j=0;
        while(i<s.size()){
            if(s[i]==t[j]){
                i++;
                j++;
            }else if(j>0){
                j = next[j-1];
            }else{
                i++;
            }
            if(j==t.size()){
                return i-j;
            }
        }
        return -1;
    }
};

struct Node {
    Node* son[26]{};
    Node* fail; // 当 cur.son[i] 不能匹配 target 中的某个字符时，cur.fail.son[i] 即为下一个待匹配节点（等于 root 则表示没有匹配）
    int len; // 从根到 node 的字符串的长度，也是 node 在 trie 中的深度

    Node(int len) : len(len) {}
};

struct AhoCorasick {
    Node* root = new Node(0);

    void put(string& s) { //普通的字典树
        auto cur = root;
        for (char b : s) {
            b -= 'a';
            if (cur->son[b] == nullptr) {
                cur->son[b] = new Node(cur->len + 1);
            }
            cur = cur->son[b];
        }
    }

    void build_fail() {
        root->fail = root;
        queue<Node*> q;
        for (auto& son : root->son) {
            if (son == nullptr) {
                son = root;//方便失配时直接跳到下一个可能匹配的位置
            } else {
                son->fail = root; // 第一层的失配指针，都指向根节点 ∅
                q.push(son);
            }
        }
        // BFS
        while (!q.empty()) {
            auto cur = q.front();
            q.pop();
            for (int i = 0; i < 26; i++) {
                auto& son = cur->son[i];
                if (son == nullptr) {
                    // 虚拟子节点 cur.son[i]，和 cur.fail.son[i] 是同一个
                    // 方便失配时直接跳到下一个可能匹配的位置（但不一定是某个 words[k] 的最后一个字母）
                    son = cur->fail->son[i];
                }else{
                    son->fail = cur->fail->son[i]; // 计算失配位置
                    q.push(son);
                }
            }
        }
    }
};

struct Compare {
    bool operator()(int a, int b) const {
        return a > b; // 降序排序
    }
};

class Solution {
public:
    void functor_test(){ //仿函数测试
        set<int,Compare> set1;
        set1.insert(1);
        set1.insert(2);
        set1.insert(3);
        set1.insert(4);
        for(auto info:set1){
            cout<<info<<endl;
        }
    }

    int eatenApples(vector<int>& apples, vector<int>& days) {
        auto cmp = [](const pair<int,int>& a,const pair<int,int>& b)->bool{
            return a.second>b.second;
        };
        priority_queue<pair<int,int>,vector<pair<int,int>>, decltype(cmp)> pq(cmp);
        int n = apples.size();
        int ans = 0;
        int day = 1;
        int index = 0;
        while(1){
            if(index<n){
                pq.emplace(apples[index],index+days[index]);//苹果个数和腐烂日期(闭区间)，按照腐烂日期从小到大排序
                index++;
            }
            while(!pq.empty()&&pq.top().second<day){//过期了
                pq.pop();
            }
            if(pq.empty()){
                if(index==n){//所有苹果都统计过了
                    break;
                }
            }else{
                ans++;
                auto tmp = pq.top();//这个tmp一定不能是auto&，否则pq.pop之后，再访问tmp就是访问非法内存了。
                pq.pop();
                if(tmp.first>1){
                    pq.emplace(tmp.first-1,tmp.second);//拿走一个苹果，剩余苹果数大于1就放回队列中
                }
            }
            day++;
        }
        return ans;
    }
};

signed main() {
    Solution s;
    vector<vector<int>> grid{{2,2}, {1,2}, {3,2}};
    vector<vector<int>> grid1{{3,1}, {3,3}, {5,2}};
    vector<int> nums{9,2};
    vector<int> nums1{3,5};
    s.eatenApples(nums,nums1);
    //    std::ios::sync_with_stdio(false);
    //    std::cin.tie(nullptr);
    //    std::cout.tie(nullptr);
    return 0;
}
