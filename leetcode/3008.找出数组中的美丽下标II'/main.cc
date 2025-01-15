template <typename T>
class KMP {
private:
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
        if (t.empty()) return vector<int>(0); // 空模式串匹配所有位置
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
                ans.push_back(i-j);
                j = next[j - 1]; // 继续寻找下一个匹配
            }
        }
        return ans;
    }
};
class Solution {
public:
    vector<int> beautifulIndices(string s, string a, string b, int k) {
        vector<char> s1(s.begin(),s.end());
        vector<char> a1(a.begin(),a.end());
        vector<char> b1(b.begin(),b.end());
        KMP<char> kmp;
        vector<int> posA = kmp.getAll(s1,a1);
        vector<int> posB = kmp.getAll(s1,b1);
        vector<int> ans;
        for (int i: posA) {
            auto it = lower_bound(posB.begin(), posB.end(), i);
            if (it != posB.end() && *it - i <= k ||
                it != posB.begin() && i - *--it <= k) {
                ans.push_back(i);//it != posB.begin() 确保 it 不是 posB 的第一个元素（否则不能通过 --it 来得到前一个元素）。
            }
        }
        return ans;
    }
};