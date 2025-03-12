class Solution {
   public:
    bool isVowels(char ch) { //判断是否为元音字符
        if (ch == 'a' || ch == 'i' || ch == 'e' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }
    int f(string word, int k) { //每个元音字母至少出现一次，并且至少包含 k 个辅音字母的子串个数。记作 f(word,k)
        int left = 0;
        int right = 0;
        int ans = 0;
        unordered_map<int, int> map1;//统计5个元音字符的出现次数
        int count = 0;//统计辅音字符个数
        while (right < word.size()) { //典型的滑动窗口
            char ch = word[right];
            if (isVowels(ch)) {
                map1[ch]++;
            } else {
                count++;
            }
            while (map1.size() == 5 && count >= k) {
                char ch1 = word[left];
                if (isVowels(ch1)) {
                    map1[ch1]--;
                    if (map1[ch1] == 0) {
                        map1.erase(ch1);
                    }
                } else {
                    count--;
                }
                left++;
            }
            ans += left;//为什么要加left?因为左区间从0，1，2一直到left-1,都满足map1.size() == 5 && count >= k，都是合法的，总共left个数
            right++;
        }
        return ans;
    }
    int countOfSubstrings(string word, int k) {
        return f(word, k) - f(word, k + 1);//建议看下方
        // https://leetcode.cn/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/solutions/2934309/liang-ci-hua-chuang-pythonjavacgo-by-end-2lpz/
    }
};