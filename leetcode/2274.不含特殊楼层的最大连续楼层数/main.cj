import std.collection.* //引入ArrayList
import std.sort.* //排序的头文件
import std.core.StringBuilder

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

    func minimumCost(m: Int64, n: Int64, horizontalCut: Array<Int64>, verticalCut: Array<Int64>): Int64 {
        var ans: Int64 = 0
        horizontalCut.sortBy(stable: true) {
            a: Int64, b: Int64 =>
            if (a < b) {
                return Ordering.LT
            } else if (a > b) {
                return Ordering.GT
            }
            return Ordering.EQ
        }
        let rows = horizontalCut
        verticalCut.sortBy(stable: true) {
            a: Int64, b: Int64 =>
            if (a < b) {
                return Ordering.LT
            } else if (a > b) {
                return Ordering.GT
            }
            return Ordering.EQ
        }
        let cols = verticalCut
        var index1 = rows.size - 1 //rows.size本身是有数据类型的，所以会自动推导类型，左侧不用写类型
        var index2 = cols.size - 1
        var row_count: Int64 = 1
        var col_count: Int64 = 1
        while (index1 >= 0 || index2 >= 0) {
            var value1 = -1
            var value2 = -1
            if (index1 >= 0) {
                value1 = rows[index1]
            }
            if (index2 >= 0) {
                value2 = cols[index2]
            }
            if (value1 > value2) {
                ans += row_count * value1
                col_count++;
                index1--;
            } else {
                ans += col_count * value2
                row_count++;
                index2--;
            }
        }
        return ans
    }

    func toBinary(n: Int64): String {
        var m = n
        var sb = StringBuilder() //函数参数均为不可变变量，在函数定义内不能对其赋值。所以不能直接修改n
        while (m != 0) {
            sb.append(m % 2)
            m /= 2
        }
        return sb.toString()
    }
    func convertDateToBinary(date: String): String {
        var sb = StringBuilder()
        var count = 0
        let hyphen: Rune = '-'
        let zero: Rune = '0'
        for (i in 0..=date.size) {
            if (i == date.size || UInt32(date[i]) == UInt32(hyphen)) {
                var tmp = toBinary(count)
                var j = tmp.size - 1
                while (j >= 0) {
                    sb.append(Rune(tmp[j]))
                    j--
                }
                if (i != date.size) {
                    sb.append('-')
                }
                count = 0
            } else {
                count *= 10
                var ch = date[i]
                var value = Int64(UInt32(ch) - UInt32(zero))
                count += value
            }
        }
        return sb.toString()
    }

    func maxConsecutive(bottom: Int64, top: Int64, special: Array<Int64>): Int64 {
        var ans:Int64 = 0
        let n = special.size
        var pre = bottom //上一个可到达的最低层数
        special.sortBy(stable: true) {
            a: Int64, b: Int64 =>
            if (a < b) {
                return Ordering.LT
            } else if (a > b) {
                return Ordering.GT
            }
            return Ordering.EQ
        }
        for(i in 0..n){
            var cur = special[i]//遍历过程中，当前能到达的最高层数。注意是开区间
            // ans = max(ans,(cur-1)-pre+1)//cur-1代表开区间
            ans = max(ans,cur-pre)//本质上是上面那行，化简了一下
            pre = cur+1
        }
        ans = max(ans,top-pre+1)
        return ans 
    }
}

main() {
    let s = Solution()
    return 0
}
