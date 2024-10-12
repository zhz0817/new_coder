import java.util.*;
public class Main {

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public static class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) { this.val = val; }
  }

  public void getNums(String s) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '[') {
        sb.append('{');
      } else if (ch == ']') {
        sb.append('}');
      } else if (ch == '"') {
        sb.append("'");
      } else {
        sb.append(ch);
      }
    }
    System.out.println(sb.toString());
  }

  int[][] dis = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
    private void dfs(char[][] grid,boolean[][] isVisited,int x,int y){
        isVisited[x][y] = true;
        for(int i=0;i<4;i++){
            int nextX = x+dis[i][0];
            int nextY = y+dis[i][1];
            if(nextX>=0&&nextX<grid.length&&nextY>=0&&nextY<grid[0].length&&
                    !isVisited[nextX][nextY]&&grid[nextX][nextY]=='1'){
                dfs(grid,isVisited,nextX,nextY);
            }
        }
    }
    public int solve (char[][] grid) {
        // write code here
        int n = grid.length;
        if(n==0){
            return 0;
        }
        int m = grid[0].length;
        boolean[][] isVisited = new boolean[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(isVisited[i],false);
        }
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'&&!isVisited[i][j]){
                    ans++;
                    dfs(grid,isVisited,i,j);
                }
            }
        }
        return ans;
    }

  public static void main(String[] args) { Main main = new Main(); }
}
