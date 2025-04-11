class Solution:
    def numberOfPowerfulInt(self, start: int, finish: int, limit: int, s: str) -> int:
        start = str(start)
        finish = str(finish)
        while len(start) < len(finish):
            start = "0" + start

        @cache
        def dfs(i:int,limitLow:bool,limitHigh:bool) -> int:
            if i == len(start):
                return 1
            lo = 0
            hi = 9
            if limitLow:
                lo = int(start[i])
            if limitHigh:
                hi = int(finish[i])
            ans = 0
            if i < len(start) - len(s):
                for d in range(lo,min(limit,hi)+1):
                    ans += dfs(i + 1, limitLow and d == lo, limitHigh and d == hi)
            else:
                x = int(s[i - (len(start) - len(s))])
                if lo <= x <= min(limit, hi):
                    ans = dfs(i+1,limitLow and x == lo,limitHigh and x == hi)
            return ans
        return dfs(0,True,True)