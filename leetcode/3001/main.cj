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
    func inBetween(left: Int64, mid: Int64, right: Int64): Bool {
        return min(left, right) < mid && mid < max(left, right);
    }
    func minMovesToCaptureTheQueen(a: Int64, b: Int64, c: Int64, d: Int64, e: Int64, f: Int64): Int64 {
        if (a == e && (c != e || !inBetween(b, d, f))) { //车和皇后X相同，并且中间没有象阻拦
            return 1;
        }
        if (b == f && (d != f || !inBetween(a, c, e))) { //车和皇后y相同，并且中间没有象阻拦
            return 1;
        }
        if (c + d == e + f && (a + b != e + f || !inBetween(c, a, e))) { //c+d == e+f代表象和皇后在同一个从右上到左下的对角线上
            return 1;
        }
        if (c - d == e - f && (a - b != e - f || !inBetween(c, a, e))) { //c-d == e-f代表象和皇后在同一个从左上到右下的对角线上
            return 1;
        }
        return 2;
    }
}

main() {
    let s = Solution();
    s.minMovesToCaptureTheQueen(4, 3, 3, 4, 5, 2);
}
