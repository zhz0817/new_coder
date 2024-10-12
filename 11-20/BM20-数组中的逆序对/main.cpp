#include <bits/stdc++.h>
using namespace std;

#define FOR_INC(i, start, end) for (int i = start; i < end; ++i)
#define FOR_DEC(i, start, end) for (int i = start; i > end; --i)
#define FOR_INC_EQUAL(i, start, end) for (int i = start; i <= end; ++i)
#define FOR_DEC_EQUAL(i, start, end) for (int i = start; i >= end; --i)

class Solution {
public:
    int ans = 0;
    const int mod = int(pow(10,9))+7;
    void merge_sort(vector<int>& nums,int left,int right,vector<int>& tmp){
        if(left==right){
            return;
        }
        int mid = left+(right-left)/2;
        int i = left , j = mid+1 ,index = left;
        merge_sort(nums,left,mid,tmp);
        merge_sort(nums,mid+1,right,tmp);
        while(i<=mid&&j<=right){
            if(nums[i]<nums[j]){
                tmp[index++]=nums[i++];
            }else{ //后面大于前面，是逆序对
                tmp[index++]=nums[j++];
                ans+=mid-i+1;//逆序对个数mid-i+1
                ans%=mod;
            }
        }
        while(i<=mid){
            tmp[index++]=nums[i++];
        }
        while(j<=right){
            tmp[index++]=nums[j++];
        }
        FOR_INC_EQUAL(p,left,right){
            nums[p] = tmp[p];
        }
    }
    int InversePairs(vector<int>& nums) {//归并排序
        // write code here
        int n = nums.size();
        vector<int> tmp(n,0);
        merge_sort(nums,0,n-1,tmp);
        cout<<this->ans<<endl;
        return this->ans;
    }
};
int main()
{
    Solution s;
    vector<int> nums{1,2,3,4,5,6,7,0};
    s.InversePairs(nums);
    return 0;
}