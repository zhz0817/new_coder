import os
import re
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
    def maxSpending(self, values: List[List[int]]) -> int:
        ans = 0
        queue = PriorityQueue()
        day = 1
        count = 0
        for value in values:
            queue.put((value[-1], count))  # q.put((priority number, data)) 优先级和元素
            count += 1
        while not queue.empty():
            tmp = queue.get()
            v = tmp[0]
            index = tmp[1]
            ans += day * v
            day += 1
            values[index].pop()
            if len(values[index]) > 0:
                queue.put((values[index][-1], index))
        return ans


if __name__ == '__main__':
    s = Solution()
