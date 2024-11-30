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

    ListNode* ReverseList(ListNode* head) {
        // write code here
        ListNode* pre = nullptr;
        ListNode* cur = head;
        while(cur!= nullptr){
            auto* tmp = cur->next;
            cur->next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    ListNode* reverseBetween(ListNode* head, int m, int n) {
        // write code here
        ListNode* pre = new ListNode(-1);
        ListNode* cur = head;
        pre->next = cur;
        ListNode* ans = pre;
        for(int i=1;i<=m;i++){
            pre = cur;
            cur = cur->next;
        }
        for(int i=m+1;i<=n;i++){
            auto* tmp = cur->next;
            cur->next = tmp->next;
            tmp->next = pre->next;
            pre->next = tmp;
        }
        return ans->next;
    }
};
int main()
{
    Solution s;
    return 0;
}