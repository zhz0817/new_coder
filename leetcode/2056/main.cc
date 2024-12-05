#include "bits/stdc++.h"

using namespace std;

#define FOR_INC(i, start, end) for (int i = start; i < end; ++i)
#define FOR_DEC(i, start, end) for (int i = start; i > end; --i)
#define FOR_INC_EQUAL(i, start, end) for (int i = start; i <= end; ++i)
#define FOR_DEC_EQUAL(i, start, end) for (int i = start; i >= end; --i)
//#define int long long

void getNums(string s){
    string t;
    for(char ch:s){
        if(ch=='['){
            t+='{';
        }else if(ch==']'){
            t+='}';
        }else{
            t+=ch;
        }
    }
    cout<<t<<endl;
}

template <class T> class FenwickTree {
    int limit;
    vector<T> arr;

    int lowbit(int x) { return x & (-x); }

public:
    FenwickTree(int limit) {
        this->limit = limit;
        arr = vector<T>(limit + 1);
    }

    void update(int idx, T delta) {
        for (; idx <= limit; idx += lowbit(idx))
            arr[idx] += delta;
    }

    T query(int idx) {
        T ans = 0;
        for (; idx > 0; idx -= lowbit(idx))
            ans += arr[idx];
        return ans;
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
        if (x == root[x])
            return x;
        return root[x] = find(root[x]);
    }

    void connect(int x, int y) {
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

    bool isConnected(int x, int y) {
        return find(x) == find(y);
    }
};


class KMP{
private:
    vector<vector<int>> dp;
    string pat_;
    int size = 128;

public:
    KMP(const string& pat){
        this->pat_ = pat;
        int n = pat.length();
        dp.resize(n,vector<int>(size,0));
        dp[0][pat[0]]=1;
        int pre = 0;
        for(int j=1;j<n;j++){
            for(int c=0;c<size;c++){
                dp[j][c] = dp[pre][c];
            }
            dp[j][pat[j]]=j+1;
            pre = dp[pre][pat[j]];
        }
    }

    int search(const string& txt){
        int M = pat_.size();
        int N = txt.size();
        int j = 0;
        for(int i=0;i<N;i++){
            j = dp[j][txt[i]];
            if(j==M){
                return i-M+1;
            }
        }
        return -1;
    }
};
struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};

class Trie{
public:
    vector<Trie*> children;
    vector<int> indexs_;
    Trie(){
        children.resize(26, nullptr);
    }

    void insert(string s,int pos,int f){
        auto root = this;
        if(f==0){
            for(int i=0;i<s.size();i++){
                int index = s[i]-'a';
                if(root->children[index]== nullptr){
                    root->children[index] = new Trie();
                }
                root = root->children[index];
                root->indexs_.push_back(pos);
            }
        }else{
            for(int i=s.size()-1;i>=0;i--){
                int index = s[i]-'a';
                if(root->children[index]== nullptr){
                    root->children[index] = new Trie();
                }
                root = root->children[index];
                root->indexs_.push_back(pos);
            }
        }
    }


    Trie* find(string s){
        auto root = this;
        for(int i=0;i<s.size();i++){
            int index = s[i]-'a';
            if(root->children[index]== nullptr){
                return nullptr;
            }
            root = root->children[index];
        }
        return root;
    }

    ~Trie() {
        for (Trie* child : children) {
            if (child != nullptr) {
                delete child;
            }
        }
    }
};



bool isPrime(int n){
    if(n<=2){
        return true;
    }
    if(n%2==0){
        return false;
    }
    for(int i=3;i<= sqrt(n);i+=2){
        if(n%i==0){
            return false;
        }
    }
    return true;
}

class SegmentTree {
public:
    SegmentTree(vector<int>& data) {
        n = data.size();
        tree.resize(2 * n);
        build(data);
    }

    void update(int index, int value) {
        int pos = index + n;
        tree[pos] += value; // 增加操作
        while (pos > 1) {
            pos /= 2;
            tree[pos] = max(tree[pos * 2], tree[pos * 2 + 1]);
        }
    }

    int query(int left, int right) {
        left += n;
        right += n + 1;
        int max_value = INT_MIN;
        while (left < right) {
            if (left & 1) {
                max_value = max(max_value, tree[left]);
                left++;
            }
            if (right & 1) {
                right--;
                max_value = max(max_value, tree[right]);
            }
            left /= 2;
            right /= 2;
        }
        return max_value;
    }

private:
    int n;
    vector<int> tree;

    void build(vector<int>& data) {
        for (int i = 0; i < n; i++) {
            tree[n + i] = data[i];
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = max(tree[i * 2], tree[i * 2 + 1]);
        }
    }
};


static const auto io_sync_off = []()
{
    // turn off sync
    std::ios::sync_with_stdio(false);
    // untie in/out streams
    std::cin.tie(nullptr);
    return nullptr;
}();
class Solution {
public:

    struct Move {
        int x0, y0; // 起点
        int dx, dy; // 移动方向
        int step;   // 移动次数
    };

    vector<vector<int>> dis = {{1,0},{-1,0},{0,1},{0,-1},
                      {1,1},{1,-1},{-1,1},{-1,-1}};
    const int SIZE = 8;
    vector<Move> generate_moves(int x,int y,int left,int right){
        vector<Move> ans = {{x,y,0,0,0}};
        for(int i=left;i<=right;i++){
            int nextX = x+dis[i][0];
            int nextY = y+dis[i][1];
            for(int step=1;0<nextX&&nextX<=SIZE&&0<nextY&&nextY<=SIZE;step++){
                ans.push_back({x,y,dis[i][0],dis[i][1],step});
                nextX += dis[i][0];
                nextY += dis[i][1];
            }
        }
        return ans;
    }
    int countCombinations(vector<string>& pieces, vector<vector<int>>& positions) {
        int n = pieces.size();
        vector<vector<Move>> all_moves(n);
        for(int i=0;i<n;i++){
            int left,right;
            if(pieces[i]=="rook"){
                left = 0;
                right = 3;
            }else if(pieces[i]=="queen"){
                left = 0;
                right = 7;
            }else{
                left = 4;
                right = 7;
            }
            all_moves[i] = generate_moves(positions[i][0],positions[i][1],left,right);
        }
        int ans = 0;
        vector<Move> paths(n);//保存每个棋子的移动路径

        auto is_valid = [](Move& m1,Move& m2)-> bool{
            int x1 = m1.x0, y1 = m1.y0;
            int x2 = m2.x0, y2 = m2.y0;
            for (int i = 0; i < max(m1.step, m2.step); i++) {
                // 每一秒走一步
                if (i < m1.step) {
                    x1 += m1.dx;
                    y1 += m1.dy;
                }
                if (i < m2.step) {
                    x2 += m2.dx;
                    y2 += m2.dy;
                }
                if (x1 == x2 && y1 == y2) { // 重叠
                    return false;
                }
            }
            return true;
        };
        function<void(int)> dfs = [&dfs,&n,&ans,&paths,&all_moves,&is_valid](int index){
            if(index==n){
                ans++;
                return;
            }
            for(Move& move1:all_moves[index]){
                bool ok = true;
                for(int j=0;j<index;j++){
                    if(!is_valid(move1,paths[j])){
                        ok = false;
                        break;
                    }
                }
                if(ok){
                    paths[index] = move1;
                    dfs(index+1);
                }
            }
        };
        dfs(0);
        return ans;
    }
};


signed main(){
    Solution s;
    vector<vector<int>> grid{{1,1}};
    vector<int> nums1{2,3,2};
    vector<int> nums2{0,1,2,3};
    vector<string> ss = {"rook"};
    cout<<s.countCombinations(ss,grid);
//    std::ios::sync_with_stdio(false);
//    std::cin.tie(nullptr);
//    std::cout.tie(nullptr);
    return 0;
}