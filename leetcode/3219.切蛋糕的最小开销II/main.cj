import std.collection.* //引入ArrayList
import std.sort.* //排序的头文件
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
        var ans:Int64 = 0
        horizontalCut.sortBy(stable:true){a:Int64,b:Int64 =>
            if(a<b){
                return Ordering.LT 
            }else if(a>b){
                return Ordering.GT 
            }
            return Ordering.EQ 
        }
        let rows = horizontalCut
        verticalCut.sortBy(stable:true){a:Int64,b:Int64 =>
            if(a<b){
                return Ordering.LT 
            }else if(a>b){
                return Ordering.GT 
            }
            return Ordering.EQ 
        }
        let cols = verticalCut
        var index1 = rows.size-1//rows.size本身是有数据类型的，所以会自动推导类型，左侧不用写类型
        var index2 = cols.size-1
        var row_count:Int64 = 1
        var col_count:Int64 = 1
        while(index1>=0||index2>=0){
            var value1 = -1
            var value2 = -1 
            if(index1>=0){
                value1 = rows[index1]
            }
            if(index2>=0){
                value2 = cols[index2]
            }
            if(value1>value2){
                ans += row_count*value1;
                col_count++;
                index1--;
            }else{
                ans += col_count*value2;
                row_count++;
                index2--;
            }
        }
        return ans 
    }
}

main() {
    let s = Solution()
}
