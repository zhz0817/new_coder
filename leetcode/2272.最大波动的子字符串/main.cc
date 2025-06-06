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

template <typename T>
class Fenwick {
   public:
    vector<T> f;
    Fenwick(vector<T>& nums) : f(nums.size() + 1) {
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            add(i + 1, nums[i]);
        }
    }

    static int lowBit(int n) { return n & -n; }

    void add(int i, T val) {
        for (; i < f.size(); i += lowBit(i)) {
            f[i] += val;
        }
    }

    T query(int i) {
        T res = T();
        for (; i > 0; i -= lowBit(i)) {
            res += f[i];
        }
        return res;
    }
};

template <typename T>
class UnionFind {
   public:
    // 构造函数显式接受size_t类型参数
    std::vector<T> root;    // 根节点数组
    std::vector<int> rank;  // 秩数组（固定为int类型）

    explicit UnionFind(size_t size) {
        root.resize(size);
        rank.resize(size, 1);  // 秩初始化为1
        for (T i = 0; i < size; ++i) {
            root[i] = i;
        }
    }

    // 路径压缩查找
    T find(T x) { return (x == root[x]) ? x : (root[x] = find(root[x])); }

    // 按秩合并（优化交换逻辑）
    void connect(T x, T y) {
        T rootX = find(x);
        T rootY = find(y);

        if (rootX == rootY) return;

        // 总是将小树合并到大树
        if (rank[rootX] < rank[rootY]) {
            root[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else {
            root[rootY] = rootX;
            rank[rootX]++;
        }
    }

    bool isConnected(T x, T y) { return find(x) == find(y); }
};

template <typename T>
class KMP {
   public:
    std::vector<int> build_next(const std::vector<T>& t) {
        std::vector<int> next;
        next.push_back(0);
        int i = 1;
        int prefix_len = 0;  // 共同的前后缀长度
        while (i < t.size()) {
            if (t[prefix_len] == t[i]) {
                prefix_len++;
                next.push_back(prefix_len);
                i++;
            } else {
                if (prefix_len == 0) {
                    next.push_back(0);
                    i++;
                } else {
                    prefix_len = next[prefix_len - 1];
                }
            }
        }
        return next;
    }

   public:
    // 搜索模式串在主串中的首次出现位置
    int search(const std::vector<T>& s, const std::vector<T>& t) {
        if (t.empty()) return 0;  // 空模式串默认匹配
        std::vector<int> next = build_next(t);
        int i = 0, j = 0;
        while (i < s.size()) {
            if (s[i] == t[j]) {
                i++;
                j++;
            } else if (j > 0) {
                j = next[j - 1];
            } else {
                i++;
            }
            if (j == t.size()) {
                return i - j;  // 返回匹配的起始位置
            }
        }
        return -1;  // 未找到匹配
    }

    // 统计模式串在主串中出现的次数
    int count(const std::vector<T>& s, const std::vector<T>& t) {
        if (t.empty()) return s.size() + 1;  // 空模式串匹配所有位置
        std::vector<int> next = build_next(t);
        int i = 0, j = 0;
        int ans = 0;
        while (i < s.size()) {
            if (s[i] == t[j]) {
                i++;
                j++;
            } else if (j > 0) {
                j = next[j - 1];
            } else {
                i++;
            }
            if (j == t.size()) {
                ans++;
                j = next[j - 1];  // 继续寻找下一个匹配
            }
        }
        return ans;
    }

    vector<int> getAll(const std::vector<T>& s, const std::vector<T>& t) {
        vector<int> ans;
        if (t.empty()) return vector<int>(0);  // 空模式串匹配所有位置
        std::vector<int> next = build_next(t);
        int i = 0, j = 0;
        while (i < s.size()) {
            if (s[i] == t[j]) {
                i++;
                j++;
            } else if (j > 0) {
                j = next[j - 1];
            } else {
                i++;
            }
            if (j == t.size()) {
                ans.push_back(i - j);
                j = next[j - 1];  // 继续寻找下一个匹配
            }
        }
        return ans;
    }
};

struct Node {
    Node* son[26]{};
    Node*
        fail;  // 当 cur.son[i] 不能匹配 target 中的某个字符时，cur.fail.son[i]
               // 即为下一个待匹配节点（等于 root 则表示没有匹配）
    int len;  // 从根到 node 的字符串的长度，也是 node 在 trie 中的深度

    Node(int len) : len(len) {}
};

struct AhoCorasick {
    Node* root = new Node(0);

    void put(string& s) {  // 普通的字典树
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
                son = root;  // 方便失配时直接跳到下一个可能匹配的位置
            } else {
                son->fail = root;  // 第一层的失配指针，都指向根节点 ∅
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
                    // 方便失配时直接跳到下一个可能匹配的位置（但不一定是某个
                    // words[k] 的最后一个字母）
                    son = cur->fail->son[i];
                } else {
                    son->fail = cur->fail->son[i];  // 计算失配位置
                    q.push(son);
                }
            }
        }
    }
};

class SegmentTreeDynamic {
   public:
    struct Node {
        int val = 0;
        bool lazy = false;
        Node *left, *right;
        Node() : val(0), lazy(false), left(nullptr), right(nullptr) {}
    };

   private:
    void pushUp(Node* node) { node->val = node->left->val + node->right->val; }
    // leftNum 和 rightNum 表示左右孩子区间的叶子节点数量
    // 因为如果是「加减」更新操作的话，需要用懒惰标记的值✖️叶子节点的数量
    void pushDown(Node* node, int leftNum, int rightNum) {
        if (node->left == nullptr) {
            node->left = new Node();
        }
        if (node->right == nullptr) {
            node->right = new Node();
        }
        if (node->lazy == 0) {  // 不需要懒更新
            return;
        }
        node->left->val += node->lazy * leftNum;
        node->right->val += node->lazy * rightNum;
        node->left->lazy += node->lazy;
        node->right->lazy += node->lazy;
        node->lazy = 0;
    }

    // 在区间 [start, end] 中更新区间 [l, r] 的值，将区间 [l, r] ➕ val
    void _update(Node* node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            // 区间节点加上更新值
            // 注意：需要✖️该子树所有叶子节点
            node->val += (end - start + 1) * val;
            // 添加懒惰标记
            // 对区间进行「加减」的更新操作，懒惰标记需要累加，不能直接覆盖
            node->lazy += val;
            return;
        }
        int mid = (start + end) >> 1;
        // 下推标记
        // mid - start + 1：表示左孩子区间叶子节点数量
        // end - mid：表示右孩子区间叶子节点数量
        pushDown(node, mid - start + 1, end - mid);
        // [start, mid] 和 [l, r] 可能有交集，遍历左孩子区间
        if (l <= mid) _update(node->left, start, mid, l, r, val);
        // [mid + 1, end] 和 [l, r] 可能有交集，遍历右孩子区间
        if (r > mid) _update(node->right, mid + 1, end, l, r, val);
        // 向上更新
        pushUp(node);
    }

    int _query(Node* node, int start, int end, int l, int r) {
        if (l <= start && end <= r) return node->val;
        // 把当前区间 [start, end] 均分得到左右孩子的区间范围
        // node 左孩子区间 [start, mid]
        // node 左孩子区间 [mid + 1, end]
        int mid = (start + end) >> 1, ans = 0;
        // 下推标记
        pushDown(node, mid - start + 1, end - mid);
        // [start, mid] 和 [l, r] 可能有交集，遍历左孩子区间
        if (l <= mid) ans += _query(node->left, start, mid, l, r);
        // [mid + 1, end] 和 [l, r] 可能有交集，遍历右孩子区间
        if (r > mid) ans += _query(node->right, mid + 1, end, l, r);
        // ans 把左右子树的结果都累加起来了，与树的后续遍历同理
        return ans;
    }

   public:
    const int L, R;
    Node root;
    SegmentTreeDynamic(int l, int r) : L(l), R(r) {}
    void buildTree(Node* node, int start, int end,
                   vector<int>& arr) {  // 静态建树
        if (start == end) {
            node->val = arr[start];
            return;
        }
        int mid = start + ((end - start) >> 1);
        buildTree(node->left, start, mid, arr);
        buildTree(node->right, mid + 1, end, arr);
        pushUp(node);
    }
    void update(int l, int r, int val) { _update(&root, L, R, l, r, val); }

    int query(int l, int r) { return _query(&root, L, R, l, r); }
};

struct Compare {
    bool operator()(int a, int b) const {
        return a > b;  // 降序排序
    }
};

int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

int lcm(int a, int b) {
    return a / gcd(a, b) * b;  // 防止溢出
}

class Solution {
   public:
    void functor_test() {  // 仿函数测试
        set<int, Compare> set1;
        set1.insert(1);
        set1.insert(2);
        set1.insert(3);
        set1.insert(4);
        for (auto info : set1) {
            cout << info << endl;
        }
    }
    int fun(string& s, char a, char b) {
        int ans = 0;
        int freqA = 0;
        int freqB = 0;
        bool hasB = 0;
        for (char ch : s) {
            if (ch == a) {
                freqA++;
            } else if (ch == b) {
                freqB++;
                hasB = true;
            }
            if (hasB) {
                ans = max(ans, freqA - freqB);
            }
            if (freqA < freqB) {
                freqA = 0;
                freqB = 0;
                hasB = false;
            }
        }
        return ans;
    }
    int largestVariance(string s) {
        int ans = 0;
        string t = s;
        std::reverse(t.begin(), t.end());
        for (char a = 'a'; a <= 'z'; a++) {
            for (char b = 'a'; b <= 'z'; b++) {
                if (a == b) {
                    continue;
                }
                ans = max(ans, fun(s, a, b));
                ans = max(ans, fun(t, a, b));
            }
        }
        return ans;
    }
};

signed main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    Solution s;
    vector<int> arr = {4, 2, 5, 9, 10, 3};
    vector<vector<int>> arr1 = {{1, 7, 3}, {9, 8, 2}, {4, 5, 6}};
}
