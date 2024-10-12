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
    ListNode* Merge(ListNode* pHead1, ListNode* pHead2) {
        // write code here
        ListNode* ans = new ListNode(-1);
        auto* node = ans;
        while(pHead1!= nullptr&&pHead2!= nullptr){
            int value1 = pHead1->val;
            int value2 = pHead2->val;
            if(value1<value2){
                node->next = pHead1;
                pHead1 = pHead1->next;
            }else{
                node->next = pHead2;
                pHead2 = pHead2->next;
            }
            node = node->next;
        }
        if(pHead1!= nullptr){
            node->next=pHead1;
        }
        if(pHead2!= nullptr){
            node->next = pHead2;
        }
        return ans->next;
    }
};
int main()
{
    Solution s;
    return 0;
}