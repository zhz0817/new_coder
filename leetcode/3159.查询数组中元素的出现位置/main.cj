import std.collection.* //引入ArrayList

class Solution {
    func max(a: Int64, b: Int64) {
        if (a > b) {
            return a;
        }
        return b;
    }

    func min(a: Int64, b: Int64) {
        if (a < b) {
            return a;
        }
        return b;
    }

    func occurrencesOfElement(nums: Array<Int64>, queries: Array<Int64>, x: Int64): Array<Int64> {
        let n = queries.size
        var cache = ArrayList<Int64>([])
        let ans = Array<Int64>(queries) //我目前没找到使用变量开一个定长数组的办法，并且仓颉的数组不支持添加删除元素

        //只能通过构造函数去构造一个和queries等长的数组。然后在原地修改。
        var index = 0
        for (i in 0..n) {
            while (index < nums.size && cache.size < queries[i]) {
                if (nums[index] == x) {
                    cache.append(index)
                }
                index++
            }
            if (cache.size >= queries[i]) {
                ans[i] = cache[queries[i] - 1]
            } else {
                ans[i] = -1
            }
        }
        return ans
    }
}

main() {
    let s = Solution()
}
