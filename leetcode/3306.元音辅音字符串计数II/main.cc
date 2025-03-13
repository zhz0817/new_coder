class Solution {
   public:
    bool isVowels(char ch) {
        if (ch == 'a' || ch == 'i' || ch == 'e' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }
    long long f(string word, int k) {
        int left = 0;
        int right = 0;
        long long ans = 0;
        unordered_map<int, int> map1;
        int count = 0;
        while (right < word.size()) {
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
            ans += left;
            right++;
        }
        return ans;
    }

    long long countOfSubstrings(string word, int k) {
        return f(word, k) - f(word, k + 1);
    }
};