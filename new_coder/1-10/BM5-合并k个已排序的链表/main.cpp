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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        // write code here
        int n = lists.size();
        ListNode* ans = new ListNode(-1);
        ListNode* node = ans;
        while(true){
            bool flag = false;
            int index = -1;
            int max_value = INT32_MAX;
            for(int i=0;i<n;i++){
                ListNode* tmp = lists[i];
                if(tmp==nullptr){
                    continue;
                }
                flag = true;
                if(tmp->val<max_value){
                    max_value = tmp->val;
                    index = i;
                }
            }
            if(!flag){
                break;
            }
            node->next = lists[index];
            node = node->next;
            lists[index] = lists[index]->next;
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