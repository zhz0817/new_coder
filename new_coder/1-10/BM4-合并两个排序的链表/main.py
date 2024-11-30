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
    def Merge(self , pHead1: ListNode, pHead2: ListNode) -> ListNode:
        # write code here
        ans = ListNode(-1)
        node = ans 
        while pHead1 is not None and pHead2 is not None:
            value1 = pHead1.val
            value2 = pHead2.val
            if value1<value2:
                node.next = pHead1
                pHead1 = pHead1.next
            else:
                node.next = pHead2
                pHead2 = pHead2.next
            node = node.next
        if pHead1 is not None:
            node.next = pHead1
        if pHead2 is not None:
            node.next = pHead2
        return ans.next