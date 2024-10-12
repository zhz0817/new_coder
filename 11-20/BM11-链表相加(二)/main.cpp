#include <bits/stdc++.h>
using namespace std;

#define FOR_INC(i, start, end) for (int i = start; i < end; ++i)
#define FOR_DEC(i, start, end) for (int i = start; i > end; --i)
#define FOR_INC_EQUAL(i, start, end) for (int i = start; i <= end; ++i)
#define FOR_DEC_EQUAL(i, start, end) for (int i = start; i >= end; --i)
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:

    vector<int> getNums(ListNode* node){
        vector<int> ans;
        while(node!=nullptr){
            ans.emplace_back(node->val);
            node = node->next;
        }
        std::reverse(ans.begin(),ans.end());//反转列表
        return ans;
    }
    ListNode* addInList(ListNode* head1, ListNode* head2) {
        // write code here
        auto nums1 = getNums(head1);
        auto nums2 = getNums(head2);
        int tmp = 0;
        ListNode* ans = new ListNode(-1);
        ListNode* node = ans;
        while(nums1.size()!=nums2.size()){//高位补0
            if(nums1.size()<nums2.size()){
                nums1.emplace_back(0);
            }else{
                nums2.emplace_back(0);
            }
        }
        vector<int> nums;
        for(int i=0;i<nums1.size();i++){
            int sum = nums1[i]+nums2[i]+tmp;
            nums.emplace_back(sum%10);
            tmp = sum/10;
        }
        if(tmp>0){
            nums.emplace_back(tmp);
        }
        for(int i=nums.size()-1;i>=0;i--){
            node->next = new ListNode(nums[i]);
            node = node->next;
        }
        return ans->next;
    }
};
int main()
{
    int a;
    Solution s;
    Solution* p = new Solution();//创建指针，指针指向的对象占用的内存会在堆区。如果在函数里创建对象，会占用栈区的内存。
    return 0;
}