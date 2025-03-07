#include "bits/stdc++.h"
using namespace std;
class Solution {
public:
    int ans;
    void dfs(vector<int>& nums, int k,int index,unordered_map<int,int>& map1){
        if(index == nums.size()){
            return;
        }
        int i = index;
        int pre = nums[i]+k;
        int next = nums[i]-k;
        if(map1.find(pre) == map1.end() && map1.find(next) == map1.end()){
            ans++;
            map1[nums[i]]++;
            dfs(nums,k,i+1,map1);
            map1[nums[i]]--;
            if(map1[nums[i]] == 0){
                map1.erase(nums[i]);
            }
        }
        dfs(nums,k,i+1,map1);//符合条件时也可以不选择当前元素，不符合条件时一定不能选。
        
    }
    int beautifulSubsets(vector<int>& nums, int k) {
        unordered_map<int,int> map1;
        dfs(nums,k,0,map1);
        return ans;
    }
};