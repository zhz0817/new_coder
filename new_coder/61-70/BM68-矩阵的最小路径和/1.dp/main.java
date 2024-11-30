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

  public int minPathSum(int[][] matrix) {
    // write code here
    int n = matrix.length;
    if (n == 0) {
      return 0;
    }
    int m = matrix[0].length;
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      dp[i][1] = matrix[i - 1][0] + dp[i - 1][1];
    }
    for (int i = 1; i <= m; i++) {
      dp[1][i] = matrix[0][i - 1] + dp[1][i - 1];
    }
    for (int i = 2; i <= n; i++) {
      for (int j = 2; j <= m; j++) {
        dp[i][j] = matrix[i - 1][j - 1] + Math.min(dp[i - 1][j], dp[i][j - 1]);
      }
    }
    return dp[n][m];
  }

  public static void main(String[] args) { Main main = new Main(); }
}
