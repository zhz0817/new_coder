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
    ListNode* deleteDuplicates(ListNode* head) {
        // write code here
        map<int,int> map1;
        ListNode* tmp = head;
        while(tmp!=nullptr){
            int value = tmp->val;
            if(map1.find(value)!=map1.end()){
                map1[value]++;
            }else{
                map1[value]=1;
            }
            tmp = tmp->next;
        }
        auto* ans = new ListNode(-1);
        ListNode* node = ans;
        tmp = head;
        while(tmp!=nullptr){
            int value = tmp->val;
            // cout<<value<<endl;
            if(map1[value]==1){
                node->next = tmp;
                node = node->next;
            }
            tmp = tmp->next;
        }
        node->next = nullptr;
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