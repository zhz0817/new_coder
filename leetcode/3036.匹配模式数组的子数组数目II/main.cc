class KMP{
private:
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
public:
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

    int count(const string& s,const string& t){
        int i=0,j=0;
        vector<int> next = build_next(t);
        int ans = 0;
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
                ans++;
                j = next[j-1];
            }
        }
        return ans;
    }
};
class Solution {
public:
    int countMatchingSubarrays(vector<int>& nums, vector<int>& pattern) {
        string s,t;
        KMP kmp;
        for(int i=1;i<nums.size();i++){
            if(nums[i]>nums[i-1]){
                s+='a';
            }else if(nums[i]==nums[i-1]){
                s+='b';
            }else{
                s+='c';
            }
        }
        for(int i=0;i<pattern.size();i++){
            if(pattern[i]==1){
                t+='a';
            }else if(pattern[i]==0){
                t+='b';
            }else{
                t+='c';
            }
        }
        return kmp.count(s,t);
    }
};