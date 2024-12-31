class Solution {
public:
    long long minimumCost(int m, int n, vector<int>& horizontalCut, vector<int>& verticalCut) {
        vector<int> rows = horizontalCut;//故意使用浅拷贝，避免多余复制
        vector<int> cols = verticalCut;//单纯想改个名，因为题干里的名字太长了
        sort(rows.begin(),rows.end());
        sort(cols.begin(),cols.end());
        long long ans = 0;
        int index1 = rows.size()-1;
        int index2 = cols.size()-1;
        int row_count = 1;
        int col_count = 1;
        while(index1>=0||index2>=0){
            int value1 = index1>=0?rows[index1]:-1;
            int value2 = index2>=0?cols[index2]:-1;
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
        return ans;
    }
};