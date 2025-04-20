class Solution:
    def countSymmetricIntegers(self, low: int, high: int) -> int:
        high = list(map(int, str(high)))
        low = list(map(int, str(low)))
        while len(low) < len(high):
            low.insert(0,0)
        n = len(low)
        @cache
        def dfs(i: int, start: int, diff: int, limit_low: bool, limit_high: bool) -> int:
            if i == n:
                if diff == 0:
                    return 1
                return 0
            lo = low[i] if limit_low else 0
            hi = high[i] if limit_high else 9

            # 如果前面没有填数字，且剩余数位个数是奇数，那么当前数位不能填数字
            if start < 0 and (n - i) % 2 == 1:
                # 如果必须填数字（lo > 0），不合法，返回 0
                return 0 if lo > 0 else dfs(i + 1, start, diff, True, False) #最高位为0，肯定不能越过上边界了，
                #所以limit_high设置为False

            res = 0
            is_left = start < 0 or i < (start + n) // 2
            for d in range(lo, hi + 1):
                res += dfs(i + 1,
                           i if start < 0 and d else start,  # 记录第一个填数字的位置
                           diff + (d if is_left else -d),  # 左半 + 右半 -
                           limit_low and d == lo,
                           limit_high and d == hi)
            return res
        return dfs(0,-1,0,True,True)