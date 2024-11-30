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

  int[][] dis = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 方向

  int ans = -1;

  private void dfs(int[][] matrix, int count, int x, int y) {
    ans = Math.max(ans, count);
    for (int i = 0; i < 4; i++) {
      int nx = dis[i][0] + x;
      int ny = dis[i][1] + y;
      if (nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length &&
          matrix[nx][ny] > matrix[x][y]) {

        dfs(matrix, count + 1, nx, ny);
      }
    }
  }
  
  public int solve(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {

        dfs(matrix, 1, i, j);
      }
    }
    return ans;
  }

  public static void main(String[] args) { Main main = new Main(); }
}
