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

    func stableMountains(height: Array<Int64>, threshold: Int64): ArrayList<Int64> {
        var ans = ArrayList<Int64>()
        let n = height.size
        for (i in 1..n) {
            if (height[i - 1] > threshold) {
                ans.append(i)
            }
        }
        return ans
    }
}

main() {
    let s = Solution()
}
