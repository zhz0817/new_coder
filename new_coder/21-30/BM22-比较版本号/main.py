class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param head ListNode类 
# @return ListNode类
#
class Solution:
    def compare(self , version1: str, version2: str) -> int:
        # write code here
        version1 = version1.split('.')
        version2 = version2.split('.')
        for i in range(max(len(version1),len(version2))):
            if i>=len(version1):
                if int(version2[i]) != 0:
                    return -1
                else:
                    continue
            elif i>=len(version2):
                if int(version1[i]) !=0:
                    return 1
                else:
                    continue
            t1 = int(version1[i])
            t2 = int(version2[i])
            if t1 > t2:
                return 1
            elif t1<t2:
                return -1
        return 0