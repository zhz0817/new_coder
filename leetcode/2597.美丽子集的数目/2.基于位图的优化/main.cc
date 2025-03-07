#include "bits/stdc++.h"
using namespace std;
class Solution {
private:
    int ret;
    int n;
    vector<bitset<18>> collisionVec;//如果第i个数字和第j个数字冲突，那么将第i个位图的第j位设置为1，18是因为题目限制1 <= nums.length <= 18
    void backtrack(int index,bitset<18> collision){
        for(int i=index+1;i<n;++i){
            if(!collision.test(i)){//test 函数检查指定位置的位是否为 1
                ++ret;
                backtrack(i,collision|collisionVec[i]);//collision|collisionVec[i]表示两个位图按位或操作，因为选择加入了新元素，
                //那么之后加入的数字不能和之前加入的任何数字发送冲突，因此按位与保存所有表示冲突的1
            }
        }
    }
public:
    int beautifulSubsets(vector<int>& nums, int k) {
        n=nums.size();
        ret=n;//每个长度为1的子集都是美丽子集
        collisionVec.resize(n);
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(nums[i]-nums[j]==k || nums[i]-nums[j]==-k){
                    collisionVec[i].set(j);//set 函数将指定位置的位设置为 1
                }
            }
        }
        for(int i=0;i<n;++i){
            backtrack(i,collisionVec[i]);
        }
        return ret;
    }
};