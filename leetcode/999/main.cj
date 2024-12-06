// import std.collection.*

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

    func numRookCaptures(board: Array<Array<Rune>>): Int64 {
        var ans: Int64 = 0;
        var x: Int64 = 0;
        var y: Int64 = 0;
        var rook: Rune = 'R';
        var p: Rune = 'p';
        var B: Rune = 'B';
        var flag: Bool = true;
        for (i in 0..8) {
            for (j in 0..8) {
                var ch = board[i][j]
                if (board[i][j] == rook) {
                    x = i
                    y = j
                    flag = false
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        for (i in 0..x) {
            var j = x - 1 - i; //不用写类型应该是做了类型推断
            let ch = board[j][y]
            if (ch == p) {
                ans++;
                break;
            } else if (ch == B) {
                break;
            }
        }
        for (i in x + 1..8) {
            let ch = board[i][y]
            if (ch == p) {
                ans++;
                break;
            } else if (ch == B) {
                break;
            }
        }
        for (i in 0..y) {
            var j = y - 1 - i; 
            let ch = board[x][j]
            if (ch == p) {
                ans++;
                break;
            } else if (ch == B) {
                break;
            }
        }
        for (i in y + 1..8) {
            let ch = board[x][i]
            if (ch == p) {
                ans++;
                break;
            } else if (ch == B) {
                break;
            }
        }
        return ans;
    }
}

main() {
    let s = Solution();
}
