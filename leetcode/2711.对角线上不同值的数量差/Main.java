class Solution {
    public int fun1(int m,int n,int[][] grid){
        Set<Integer> set = new HashSet<>();
        while (true){
            m--;
            n--;
            if(m<0||n<0)
                break;
            set.add(grid[m][n]);
        }
        return set.size();
    }

    public int fun2(int m,int n,int[][] grid){
        Set<Integer> set = new HashSet<>();
        while (true){
            m++;
            n++;
            if(m>=grid.length||n>=grid[0].length)
                break;
            set.add(grid[m][n]);
        }
        return set.size();
    }
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int left = fun1(i,j,grid);
                int right = fun2(i,j,grid);
                ans[i][j] = Math.abs(left-right);
            }
        }
        return ans;
    }
}