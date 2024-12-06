import os
from cmath import inf
from functools import cache
from queue import PriorityQueue
from typing import List
import sys

sys.set_int_max_str_digits(0)


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def numRookCaptures(self, board: List[List[str]]) -> int:

        def find():
            nonlocal board
            for i in range(8):
                for j in range(8):
                    if board[i][j] == 'R':
                        return i, j
            return -1, -1

        x, y = find()
        ans = 0
        for i in range(x - 1, -1, -1):  # 逆序遍历，注意右侧X是开区间取不到
            ch = board[i][y]
            if ch == 'p':
                ans += 1
                break
            elif ch == 'B':
                break
        for i in range(x + 1, 8):
            ch = board[i][y]
            if ch == 'p':
                ans += 1
                break
            elif ch == 'B':
                break
        for i in range(0, y)[::-1]:
            ch = board[x][i]
            if ch == 'p':
                ans += 1
                break
            elif ch == 'B':
                break
        for i in range(y + 1, 8):
            ch = board[x][i]
            if ch == 'p':
                ans += 1
                break
            elif ch == 'B':
                break
        return ans


if __name__ == '__main__':
    s = Solution()
    ans = s.numRookCaptures([[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]])
    print(ans)