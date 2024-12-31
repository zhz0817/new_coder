import os
import random
import re
from cmath import inf
from functools import cache
from queue import PriorityQueue
from typing import List
import sys
import pandas as pd

sys.set_int_max_str_digits(0)


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def minimumCost(self, m: int, n: int, horizontalCut: List[int], verticalCut: List[int]) -> int:
        horizontalCut.sort()  # 默认从小到达排序
        verticalCut.sort()
        rows = horizontalCut  # 浅拷贝,不懂的百度一下
        cols = verticalCut
        ans = 0
        index1 = len(rows) - 1
        index2 = len(cols) - 1
        row_count = 1
        col_count = 1
        while index1 >= 0 or index2 >= 0:
            value1 = -1
            value2 = -1
            if index1 >= 0:
                value1 = rows[index1]
            if index2 >= 0:
                value2 = cols[index2]
            if value1 > value2:
                ans += row_count * value1
                col_count += 1
                index1 -= 1
            else:
                ans += col_count * value2
                row_count += 1
                index2 -= 1
        return ans


if __name__ == '__main__':
    s = Solution()
    s.minimumCost(3, 2, [1, 3], [5])
