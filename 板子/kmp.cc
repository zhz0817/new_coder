#include "bits/stdc++.h"

using namespace std;
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
};

signed main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    return 0;
}