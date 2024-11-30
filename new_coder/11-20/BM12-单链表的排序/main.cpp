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


bool cmp(ListNode* a,ListNode* b){
    return a->val<b->val;
}
class Solution {
public:
    ListNode* sortInList(ListNode* head) {
        // write code here
        if(head==nullptr){
            return nullptr;
        }
        vector<ListNode*> vector1;
        while (head!=nullptr){
            vector1.emplace_back(head);
            head = head->next;
        }
        sort(vector1.begin(),vector1.end(),cmp);
        auto ans = vector1[0];
        for(int i=0;i<vector1.size()-1;++i){
            vector1[i]->next = vector1[i+1];
        }
        vector1[vector1.size()-1]->next = nullptr;
        return ans;
    }
};
int main()
{
    int a;
    Solution s;
    Solution* p = new Solution();//创建指针，指针指向的对象占用的内存会在堆区。如果在函数里创建对象，会占用栈区的内存。
    return 0;
}