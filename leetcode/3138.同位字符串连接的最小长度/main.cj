import std.collection.*

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

    func minAnagramLength(s: String): Int64 {
        let n = s.size
        let a = ArrayList<Int64>(26);
        for (i in 0..26) {
            a.append(0)
        }
        let b = ArrayList<Int64>(26);
        for (i in 0..26) {
            b.append(0)
        }
        for (k in 1..=n / 2) { //k是最短子串长度，通过从小到大遍历进行模拟，获取最小值。注意右边界到n / 2即可，超过就是重复计算了，没意义。
            if (n % k != 0) { //无法整除代表无法切割，即无法拼接
                continue
            }
            for (i in 0..26) {
                a[i] = 0
            }
            for (i in 0..k) {
                let index = Int64(UInt32(Rune(s[i])) - UInt32(r'a'))
                a[index]++;
            }//存储前k个字符
            var ok: Bool = true
            var i = k * 2
            while (i <= n) {
                for (j in 0..26) {
                    b[j] = 0
                }
                for (j in i - k..i) {
                    let index = Int64(UInt32(Rune(s[j])) - UInt32(r'a'))
                    b[index]++;
                }
                for (j in 0..26) {
                    if (a[j] != b[j]) {//每k个字符对比一次
                        ok = false
                        break
                    }
                }
                i += k
            }
            if (ok) {
                return k
            }
        }
        return n
    }
}

main() {
    let s = Solution();
    var t = "abc"
    println(UInt32(Rune(t[0])) - UInt32(r'a'))
}
