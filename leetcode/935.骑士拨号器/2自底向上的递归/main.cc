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
        } else {
            t += ch;
        }
    }
    cout << t << endl;
}

template <class T>
class FenwickTree {
    int limit;
    vector<T> arr;

    int lowbit(int x) { return x & (-x); }

   public:
    FenwickTree(int limit) {
        this->limit = limit;
        arr = vector<T>(limit + 1);
    }

    void update(int idx, T delta) {
        for (; idx <= limit; idx += lowbit(idx)) arr[idx] += delta;
    }

    T query(int idx) {
        T ans = 0;
        for (; idx > 0; idx -= lowbit(idx)) ans += arr[idx];
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
        if (x == root[x]) return x;
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

    bool isConnected(int x, int y) { return find(x) == find(y); }
};

class KMP {
   private:
    vector<vector<int>> dp;
    string pat_;
    int size = 128;

   public:
    KMP(const string& pat) {
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

    int search(const string& txt) {
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
struct ListNode {
    int val;
    struct ListNode* next;
    ListNode(int x) : val(x), next(nullptr) {}
};

class Trie {
   public:
    vector<Trie*> children;
    vector<int> indexs_;
    Trie() { children.resize(26, nullptr); }

    void insert(string s, int pos, int f) {
        auto root = this;
        if (f == 0) {
            for (int i = 0; i < s.size(); i++) {
                int index = s[i] - 'a';
                if (root->children[index] == nullptr) {
                    root->children[index] = new Trie();
                }
                root = root->children[index];
                root->indexs_.push_back(pos);
            }
        } else {
            for (int i = s.size() - 1; i >= 0; i--) {
                int index = s[i] - 'a';
                if (root->children[index] == nullptr) {
                    root->children[index] = new Trie();
                }
                root = root->children[index];
                root->indexs_.push_back(pos);
            }
        }
    }

    Trie* find(string s) {
        auto root = this;
        for (int i = 0; i < s.size(); i++) {
            int index = s[i] - 'a';
            if (root->children[index] == nullptr) {
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

bool isPrime(int n) {
    if (n <= 2) {
        return true;
    }
    if (n % 2 == 0) {
        return false;
    }
    for (int i = 3; i <= sqrt(n); i += 2) {
        if (n % i == 0) {
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
        tree[pos] += value;  // 增加操作
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

static const auto io_sync_off = []() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    return nullptr;
}();

class Solution {
   public:
    const int mod = 1000000007;
    vector<vector<int>> moves = {{4, 6}, {6, 8},    {7, 9}, {4, 8}, {3, 9, 0},
                                 {},     {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
    // 电话键盘上，0能跳到4和6，1能跳到6和8,类推

    int n;
    int dfs(int index, int count) {
        int ans = 0;
        if (count == n) {
            return 1;
        }
        for (int i = 0; i < moves[index].size(); i++) {
            ans += dfs(moves[index][i], count + 1);
            ans %= mod;
        }
        return ans;
    }
    int knightDialer(int n) {
        this->n = n;
        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += dfs(i, 1);
            ans %= mod;
        }
        return ans;
    }
};

signed main() {
    Solution s;
    vector<vector<int>> grid{{1, 1}};
    vector<int> nums1{2, 3, 2};
    vector<int> nums2{0, 1, 2, 3};
    vector<string> ss = {"rook"};
    //    std::ios::sync_with_stdio(false);
    //    std::cin.tie(nullptr);
    //    std::cout.tie(nullptr);
    return 0;
}