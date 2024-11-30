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
    def solve(self , queryIP: str) -> str:
        # write code here
        if '.' in queryIP:
            s = queryIP.split('.')
            if len(s) != 4:
                return 'Neither'
            for t in s:
                if t.startswith('0') and len(t) > 1:
                    return 'Neither'
                try:  # 192.168.1.1e
                    val = int(t)
                except:
                    return 'Neither'
                if val > 255:
                    return 'Neither'
            return 'IPv4'
        elif ':' in queryIP:
            set1 = set()
            for i in range(0, 10):
                set1.add(str(i))
            set1.add('a')
            set1.add('b')
            set1.add('c')
            set1.add('d')
            set1.add('e')
            set1.add('f')
            set1.add('A')
            set1.add('B')
            set1.add('C')
            set1.add('D')
            set1.add('E')
            set1.add('F')
            s = queryIP.split(':')
            if len(s) != 8:
                return 'Neither'
            for t in s:
                if len(t) == 0:
                    return 'Neither'
                flag = False
                for i in range(len(t)):
                    if t[i] not in set1:
                        return 'Neither'
                    if t[i] != "0":
                        flag = True
                if not flag and len(t)>1:
                    return 'Neither'
            return "IPv6"
        return 'Neither'