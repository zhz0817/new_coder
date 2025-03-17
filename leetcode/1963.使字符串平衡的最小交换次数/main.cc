#include "bits/stdc++.h"
using namespace std;
class Solution {
   public:
    // int minSwaps(string s) { //下方可以用计数器模拟栈
    //     stack<char> stack1;
    //     for (char ch : s) {
    //         if (ch == '[') {
    //             stack1.push(ch);
    //         } else {
    //             if (!stack1.empty()) {
    //                 stack1.pop();
    //             }
    //         }
    //     }
    //     int n = stack1.size();
    //     return n % 2 == 0 ? n / 2 : n / 2 + 1;
    // }
    

    //首先用栈计算有多少个不匹配的括号，遍历到最后，栈的长度就是不匹配左括号数或者不匹配右括号数
    //接下来是贪心的思想，尽量交换比较远的左右括号。
    // （1）
    //如果未匹配的右括号数大于等于2，那么实际上交换后的左括号和距离它较近的右括号会匹配上，
    //并且交换的右括号也去到了正确的位置，一次消灭了2个未匹配的右括号。需要交换n/2次。n是未匹配右括号的个数
    // （2）
    //如果未匹配的右括号数等于1，那么只需再交换1次。.
    // （3）
    // 所以最小的总交换次数是n % 2 == 0 ? n / 2 : n / 2 + 1;
    int minSwaps(string s) {
        int count = 0;
        for (char ch : s) {
            if (ch == '[') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                }
            }
        }
        return count % 2 == 0 ? count / 2 : count / 2 + 1;
    }
};