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
    ListNode* FindKthToTail(ListNode* pHead, int k) {
        // write code here
        vector<ListNode*> vector1;
        auto* node = pHead;
        while(node!=nullptr){
            vector1.emplace_back(node);
            node = node->next;
        }
        if(vector1.size()<k){
            return nullptr;
        }
        return vector1[vector1.size()-k];
    }
};
int main()
{
    int a;
    Solution s;
    Solution* p = new Solution();//创建指针，指针指向的对象占用的内存会在堆区。如果在函数里创建对象，会占用栈区的内存。
    return 0;
}