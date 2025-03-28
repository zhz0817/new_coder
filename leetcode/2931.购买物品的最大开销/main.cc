#include "bits/stdc++.h"

using namespace std;

#define FOR_INC(i, start, end) for (int i = start; i < end; ++i)
#define FOR_DEC(i, start, end) for (int i = start; i > end; --i)
#define FOR_INC_EQUAL(i, start, end) for (int i = start; i <= end; ++i)
#define FOR_DEC_EQUAL(i, start, end) for (int i = start; i >= end; --i)
//#define int long long

void getNums(string s)
{
    string t;
    for (char ch : s)
    {
        if (ch == '[')
        {
            t += '{';
        }
        else if (ch == ']')
        {
            t += '}';
        }
        else if(ch == '"'){
            t += "'";
        }
        else
        {
            t += ch;
        }
    }
    cout << t << endl;
}
class Fenwick
{

public:
    vector<int> f;
    Fenwick(int n) : f(n + 1)
    {
        for (int i = 0; i < n; i++)
        {
            add(i + 1, f[i]);
        }
    }
    static int lowBit(int n)
    {
        return n & -n;
    }
    void add(int i, int val)
    {
        for (; i < f.size(); i += lowBit(i))
        {
            f[i] += val;
        }
    }

    int query(int i)
    {
        int res = 0;
        for (; i > 0; i -= lowBit(i))
        {
            res += f[i];
        }
        return res;
    }

    int get(int index)
    {
        return f[index];
    }
};

class UnionFind
{
    std::vector<int> root;
    std::vector<int> rank;

public:
    explicit UnionFind(int size)
    {
        root.resize(size);
        rank.resize(size);
        for (int i = 0; i < size; ++i)
        {
            root[i] = rank[i] = i;
        }
    }

    int find(int x)
    {
        if (x == root[x])
            return x;
        return root[x] = find(root[x]);
    }

    void connect(int x, int y)
    {
        if(x>y){
            connect(y,x);
        }
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY)
        {
            if (rank[rootX] > rank[rootY])
            {
                root[rootY] = rootX;
            }
            else if (rank[rootX] < rank[rootY])
            {
                root[rootX] = rootY;
            }
            else
            {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    bool isConnected(int x, int y)
    {
        return find(x) == find(y);
    }
};

class NumArray
{

private:
    vector<int> nums_;
    Fenwick *fenwick_;

public:
    NumArray(vector<int> &nums) : nums_(nums)
    {
        fenwick_ = new Fenwick(nums.size() + 1);
        for (int i = 1; i <= nums.size(); i++)
        {
            fenwick_->add(i, nums[i - 1]);
        }
    }

    void update(int index, int val)
    {
        fenwick_->add(index + 1, val - fenwick_->f[index]);
        fenwick_->f[index] = val;
    }

    int sumRange(int left, int right)
    {
        return fenwick_->query(right + 1) - fenwick_->query(left);
    }
};

class KMP
{
private:
    vector<vector<int>> dp;
    string pat_;
    int size = 128;

public:
    KMP(const string &pat)
    {
        this->pat_ = pat;
        int n = pat.length();
        dp.resize(n, vector<int>(size, 0));
        dp[0][pat[0]] = 1;
        int pre = 0;
        for (int j = 1; j < n; j++)
        {
            for (int c = 0; c < size; c++)
            {
                dp[j][c] = dp[pre][c];
            }
            dp[j][pat[j]] = j + 1;
            pre = dp[pre][pat[j]];
        }
    }

    int search(const string &txt)
    {
        int M = pat_.size();
        int N = txt.size();
        int j = 0;
        for (int i = 0; i < N; i++)
        {
            j = dp[j][txt[i]];
            if (j == M)
            {
                return i - M + 1;
            }
        }
        return -1;
    }
};
struct ListNode
{
    int val;
    struct ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};


bool isPrime(int n)
{
    if (n <= 2)
    {
        return true;
    }
    if (n % 2 == 0)
    {
        return false;
    }
    for (int i = 3; i <= sqrt(n); i += 2)
    {
        if (n % i == 0)
        {
            return false;
        }
    }
    return true;
}

class SegmentTree
{
public:
    SegmentTree(vector<int> &data)
    {
        n = data.size();
        tree.resize(2 * n);
        build(data);
    }

    void update(int index, int value)
    {
        int pos = index + n; // 将原数组的索引映射到线段树的叶子节点位置
        tree[pos] += value;  // 更新对应位置的叶子节点（这里是增加操作）
        while (pos > 1)
        {                                                      // 向上更新线段树的父节点
            pos /= 2;                                          // 移动到父节点
            tree[pos] = max(tree[pos * 2], tree[pos * 2 + 1]); // 更新父节点的值为子节点的最大值
        }
    }

    int query(int left, int right)
    {
        left += n;               // 将查询区间的左端点映射到线段树
        right += n + 1;          // 将查询区间的右端点映射到线段树（右端点是开区间）
        int max_value = INT_MIN; // 用来存储查询结果的变量
        while (left < right)
        {
            if (left & 1)
            {                                           // 如果左端点是奇数，说明左端点是一个右子节点
                max_value = max(max_value, tree[left]); // 将左端点的值与当前最大值比较
                left++;                                 // 左端点向右移动
            }
            if (right & 1)
            {                                            // 如果右端点是奇数，说明右端点是一个左子节点
                right--;                                 // 右端点向左移动
                max_value = max(max_value, tree[right]); // 将右端点的值与当前最大值比较
            }
            left /= 2;  // 向上移动到父节点
            right /= 2; // 向上移动到父节点
        }
        return max_value; // 返回区间的最大值
    }

private:
    int n;
    vector<int> tree;

    void build(vector<int> &data)
    {
        for (int i = 0; i < n; i++)
        {
            tree[n + i] = data[i]; // 将数据填充到线段树的叶子节点
        }
        for (int i = n - 1; i > 0; i--)
        {
            tree[i] = max(tree[i * 2], tree[i * 2 + 1]); // 合并左右子树的最大值
        }
    }
};

class Solution {
public:
    long long maxSpending(vector<vector<int>>& values) {
        priority_queue<pair<int,int>,vector<pair<int,int>>, greater<>> queue1;
        long long ans = 0;
        long long day = 1;
        int count = 0;
        for(auto& value:values){
            queue1.emplace(value.back(),count);
            count++;
        }
        count = 0;
        while(!queue1.empty()){
            auto [value,index] = queue1.top();
            ans += value*day;
            day++;
            values[index].pop_back();
            queue1.pop();
            if(!values[index].empty()){
                queue1.emplace(values[index].back(),index);
            }
        }
        return ans;
    }
};

signed main()
{
    Solution s;
    vector<vector<int>> grid{{8,5,2},{6,4,1},{9,7,3}};
    vector<int> nums{1,2,3,4,3,2,5};
    s.maxSpending(grid);
//    std::ios::sync_with_stdio(false);
//    std::cin.tie(nullptr);
//    std::cout.tie(nullptr);
    return 0;
}
