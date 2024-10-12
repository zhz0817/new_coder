class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param head ListNode类 
# @param m int整型 
# @param n int整型 
# @return ListNode类
#
class Solution:
    def ReverseList(self, pre: ListNode, cur: ListNode, count: int) -> ListNode:
        # write code here
        head = pre
        while cur is not None and count > 0:
            tmp = cur.next
            cur.next = pre
            pre = cur
            cur = tmp
            count -= 1
        head.next = cur
        return pre

    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        # write code here
        pre = ListNode(-1)
        cur = head
        pre.next = cur
        ans = pre
        for i in range(1, m):
            pre = cur
            cur = cur.next
        pre.next = self.ReverseList(pre.next, cur.next, n - m)
        return ans.next