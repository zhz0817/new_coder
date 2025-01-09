class Solution {
public:
    int cur[26],aim[26];
    bool fun(){
        for(int i=0;i<26;i++){
            if(cur[i]<aim[i]){
                return false;
            }
        }
        return true;
    };
    long long validSubstringCount(string word1, string word2) {
        for(int i=0;i<word2.size();i++){
            aim[word2[i]-'a']++;
        }
        int left = 0;
        int right = 0;
        long long ans = 0;
        while(right<word1.size()){
            int index = word1[right]-'a';
            cur[index]++;
            while(fun()){
                ans+=word1.size()-right;
                cur[word1[left]-'a']--;
                left++;
            }
            right++;
        }
        return ans;
    }
};