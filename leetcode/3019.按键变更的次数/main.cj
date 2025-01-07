class Solution {
    func countKeyChanges(s: String): Int64 {
        var ans = 0
        var pre = s[0]
        for (i in 1..s.size) {
            var ch = s[i] //类型是UInt8
            if (ch == pre || ch == pre - 32 || ch == pre + 32) {
            } else {
                ans++;
            }
            pre = ch
        }
        return ans
    }
}